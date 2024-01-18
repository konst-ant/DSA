package passedInterviews;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstring {

    private static int maxSubStringLength(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int maximumLength = 0;
        boolean visit[] = new boolean[256];
        int start = 0;
        int end = 0;
        /** catapillar method here:
         *  start - end bound the next considerable substring.
         *  first moving end until we meet some repeated character.
         *
         *  in this event go moving 'start' ahead until we step on these charater that we stepped in at end i.e. the
         *  repeated one, and then we will get a substring with all unrepeated characters. Take max of that. And move
         *  ahead with the same method. 5-star solution.
         */
        while (end < S.length()) {  // o(n)
            if (visit[S.charAt(end)]) {
                while (visit[S.charAt(end)]) {
                    visit[S.charAt(start)] = false;
                    start++;
                }
            }
            visit[S.charAt(end)] = true;
            maximumLength = Math.max(maximumLength, (end - start + 1));
            end++;
        }
        return maximumLength;
    }

    public static void main(String[] args) {
        System.out.println(maxSubStringLength("aabbcc"));
        System.out.println(maxSubStringLength("abcabcbb"));
    }
}
