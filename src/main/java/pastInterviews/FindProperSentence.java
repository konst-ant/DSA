package pastInterviews;

import java.util.ArrayList;

/**
 *
 * Given a String "word" and an array of Strings "words", add spaces in "word" to construct a sentence
 * where each word is a valid word from "words". Return all such possible sentences in any order.
 *
 * Note: The same word in the "words" may be reused multiple times in the segmentation.
 *
 * Example 1::
 * Input: word = "batsandcows", words = {"bat", "bats", "and", "sand", "cows", "cow"}
 * Output: {"bat sand cows", "bats and cows"}
 *
 * Example 2::
 * Input: word = "basand", words = {"bat", "bats", "and", "sand", "cows", "cow"}
 * Output: {}
 *
 * Constraints::
 * 1 <= word.length <= 20
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 10
 * Word and words[i] consist of lowercase English letters.
 * All the strings of words array are unique.
 *
 */
public class FindProperSentence {

    public static void main(String[] args) {
        String words[] = {"cows", "bat", "bats", "and", "sand", "cow"};
        System.out.println(solution("batsandcow", words));
    }

    public static ArrayList<String> solution(String word, String[] words) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (word.startsWith(words[i])) {
                String sentence = words[i];
                String resultSentence = words[i] + " ";
                for (int j = i + 1; j < words.length; j++) {
                    if (word.contains(sentence + words[j])) {
                        sentence += words[j];
                        resultSentence += words[j] + " ";
                    }
                }
                if (sentence.length() == word.length()) {
                    result.add(resultSentence);
                }
            }
        }
        return result;
    }
}
