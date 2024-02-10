package pastInterviews;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Codility
 *
 * Calculate how many times you can print the word "BANANA" using the letters given in string S.
 *
 * The string S made of uppercase English letters is given. In one move six letters forming the word
 * "BANANA" (one B, three A, and two N) can be deleted from S. What is the maximum number of times such
 * a move can be applied to S?
 *
 * Write a method:
 *
 * public int solution(String S);
 *
 * that given as string S of length N returns the maximum number of moves that can be applied.
 *
 * For example:
 * "NAABXXAN" -> "XX" - should return 1
 * "NAANAAXNABABYNNBZ" -> "NAAXNABYNBZ" -> "XBYNZ" - should return 2
 * "QABAAAWOBL" - should return 0
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1 .. 100 000]
 * - string S is made only of uppercase letters (A-Z)
 *
 *
 */
class CountBananas {
    public int solution(String S) {
        // List<String> banana=Arrays.asList("BANANA".split(""));
        Map<String,Long> countmap= Arrays.stream(S.split("")).collect(Collectors.groupingBy(
                Function.identity(),
                HashMap::new,
                Collectors.counting()));
        return  rec(countmap,1);
        // Implement your solution here
    }
    private int rec(Map<String, Long> countMap ,int count){
        if(countMap.containsKey("B") && countMap.containsKey("A") && countMap.containsKey("N")) {
            if(countMap.get("B")<1 ||countMap.get("A")<3||countMap.get("N")<2)
                return 0;

            countMap.put("B",countMap.get("B")-1);
            countMap.put("A",countMap.get("A")-3);
            countMap.put("N",countMap.get("N")-2);
            return count+rec(countMap,count);
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        CountBananas countBananas = new CountBananas();
        System.out.println(countBananas.solution("NAABXXAN"));
        System.out.println(countBananas.solution("NAANAAXNABABYNNBZ"));
        System.out.println(countBananas.solution("QABAAAWOBL"));
    }

}