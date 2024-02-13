package dp;

/**
 * You are given an array of positive numbers. You are at liberty to set + or - to each element.
 * Write a method returning the number of variants to assign signs so that the lump sum delivers given positive number s:
 * <p>
 * public int positiveNegative(int[] arr, int s)
 *
 * The problem is reduced down to the case of checking if exists subset with sum S (DoesExistSubsetOfSumTabular).
 * How:
 *      all numbers taken as negatives we join into S1
 *      all number taken as positives we join into S2
 *
 *      To satisfy target condition we need S2 - S1 = S
 *      On the other hand S2 + S1 = sum(arr)
 *
 *      Summing up two equations:
 *      2 * S2 = S + sum(arr)
 *      S2 = (S + sum(arr)) / 2
 *
 *      Here S + sum(arr) necessarily must be even, otherwise the result will be false.
 *      So, we apply the same algo to find subset S2, who's sum equals to (S + sum(arr))/2
 */
public class PositiveOrNegativeRecursive {
    public static void main(String[] args) {

    }
}
