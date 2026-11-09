package faang.dp1d;

import java.util.List;

/**
 * LC 139: Word Break.
 * Determine whether a string can be segmented into a space-separated sequence of dictionary words.
 * Precondition: s must be non-null, and wordDict must be non-null and non-empty.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            throw new IllegalArgumentException("s must be non-null");
        }
        if (wordDict == null || wordDict.isEmpty()) {
            throw new IllegalArgumentException("wordDict must be non-null and non-empty");
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak("", List.of("leet", "code")));
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
