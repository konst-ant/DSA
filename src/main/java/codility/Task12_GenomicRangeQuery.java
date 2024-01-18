package codility;


/**
 *
 * A DNA sequence can be represented as a string consisting of letters A, C, G, T.
 * Each letter correspond to nucleotide, and each has an impact factor correspondingly 1, 2, 3, 4.
 *
 * Given a string with DNA sequence of size N, there is required to calculate the impact factor for the series of
 * subsequences in that DNA sequence.
 *
 * Each subsequence in DNA sequence is identified with start index and end index (inclusively).
 * Start indexes are provided in array P[] of size M. End indexes are provided in array Q[] of size M.
 *
 * The rule for impact factor of the subsequence is - the nucleotide with lowest impact factor is the impact factor of
 * that subsequence.
 *
 * Write an effective algorithm, which given the DNA string of size N, arrays of subsequences start and end index  P[] and Q[] of size M,
 * will return array of that subsequences impact factors of size M.
 *
 * public int[] solution(String S, int[] P, int[] Q);
 *
 * For example, given:
 *
 * S = "CAGCCTA"
 * P[] = {2, 5, 0}
 * Q[] = {4, 5, 6}
 *
 * the result will be
 * {2, 4, 1}
 *
 * because
 *
 * first subsequence "GCC" impact factor is 2 (C),
 * second subsequence "T" impact factor is 4 (T),
 * third subsequence "CAGCCTA" impact factor is 1 (A)
 *
 */

public class Task12_GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int len = S.length();
        int[][] counters = new int[3][len + 1];

        char[] schar = S.toCharArray();

        int countA=0;
        int countC=0;
        int countG=0;

        for (int i = 0 ; i<schar.length; i++) {
            if (schar[i] == 'A') {
                countA++;
            } else if (schar[i] == 'C') {
                countC++;
            } else if (schar[i] == 'G') {
                countG++;
            }
            counters[0][i+1] = countA;
            counters[1][i+1] = countC;
            counters[2][i+1] = countG;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < result.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            if (counters[0][start] < counters[0][end]) {
                result[i] = 1;
            } else if (counters[1][start] < counters[1][end]) {
                result[i] = 2;
            } else if (counters[2][start] < counters[2][end]) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Task12_GenomicRangeQuery genomicRangeQuery = new Task12_GenomicRangeQuery();
        for (int i : genomicRangeQuery.solution("CAGCCTA", new int[]{2,5,0}, new int[] {4,5,6})) {
            System.out.println(i + " ");
        }
//        for (int i : genomicRangeQuery.solution("CAATGGA", new int[]{2,5,0}, new int[] {4,5,6})) {
//            System.out.println(i + " ");
//        }

    }
}
