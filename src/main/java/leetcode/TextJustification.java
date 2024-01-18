package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * Example 3:
 *
 * Input: words = [ ], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 */

public class TextJustification {

    public static void main(String[] args) {
        int maxWidth = 16;
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.textJustify(words, maxWidth));
    }

    public List<String> textJustify(String[] words, int maxWidth) {
        int n = words.length;

        List<String> ans = new ArrayList<>();
        int start=0;
        while(start<n){
            int[] idxSum = decideLine(words, start, maxWidth, n);
            int end = idxSum[0];
            int cumSum = idxSum[1];
            ans.add(createLine(words, start, end, cumSum, maxWidth, n));
            start = end+1;
        }
        return ans;
    }
    public int[] decideLine(String[] words, int start, int maxWidth, int n){
        int cumSum = 0, spaces = 0;
        int end = start;

        while(end<n){
            cumSum += words[end].length();
            if(cumSum + spaces > maxWidth){
                return new int[]{end-1, cumSum - words[end].length()};
            }
            spaces++; // for space
            end++;
        }
        return new int[]{end-1, cumSum};
    }
    public String createLine(String[] words, int start, int end, int cumSum, int maxWidth, int n){

        int spaces = maxWidth - cumSum;
        int wordSpaces = end - start;
        int reqSpaces = (end == n-1 || end==start)? 0 : spaces / wordSpaces;

        StringBuilder spaceWord = new StringBuilder();
        while(reqSpaces>0){
            spaceWord.append(' ');
            reqSpaces--;
        }

        int extraSpacing = (end == n-1 || end==start)? spaces : spaces % wordSpaces;

        StringBuilder sb = new StringBuilder();

        while(sb.length() !=  maxWidth){

            if(start <= end)
                sb.append(words[start]);

            if(start++ < end)
                sb.append(spaceWord);//only if the word is not the end

            if(extraSpacing>0){
                sb.append(' ');//adding the extra spaces!
                extraSpacing--;
            }
        }
        return sb.toString();
    }
}
