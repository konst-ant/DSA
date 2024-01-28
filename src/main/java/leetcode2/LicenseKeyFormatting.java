package leetcode2;


import java.util.Arrays;

/**
 *
 * You are given a license key represented as a string s that consists of only alphanumeric characters
 * and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 *
 * We want to reformat the string s such that each group contains exactly k characters, except for the
 * first group, which could be shorter than k but still must contain at least one character. Furthermore,
 * there must be a dash inserted between two groups, and you should convert all lowercase letters to
 * uppercase.
 *
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.reformat2("abcd-efgh", 7)) ;
        System.out.println(licenseKeyFormatting.reformat2("abcd-efgh-ijkl-mnop", 7)) ;
        System.out.println(licenseKeyFormatting.reformat2("abcd-efgh-ijkl-mnop", 2)) ;
        System.out.println(licenseKeyFormatting.reformat2("abcd-efgh-ijkl-mnop", 3)) ;
        System.out.println(licenseKeyFormatting.reformat2("abcd-efgh-ijkl-mnop", 4)) ;
    }

    /**
     * Alternatively operate on pre-allocated result char[]
     * Here we traverse the input string in reverse order
     */
    public String reformat2(String s, int k) {

        // number of dashes in original string
        int dashes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                dashes++;
            }
        }

        int newDashes = (int) Math.ceil((double) (s.length() - dashes) / k) -1;
        char[] result = new char[s.length() - dashes + newDashes];

        int j = result.length - 1; // pointer on result
        int groupCounter = 0;   // accounting in groups separated with dashes
        for (int i = s.length() - 1; i >= 0; i--) {
            if (groupCounter == k) {
                result[j--] = '-';
                groupCounter=0;
            }

            if (s.charAt(i) != '-') {
                result[j--] = s.charAt(i);
                groupCounter++;
            }
        }

        return Arrays.toString(result).toUpperCase();
    }

    /**
     * Use reversing original string for convenient processing, and in the end reverse it back
     *
     */
    public String reformat(String s, int k) {
        StringBuilder result = new StringBuilder();
        StringBuilder batch = new StringBuilder();
        int counter=0;
        for (Character c: (new StringBuilder(s)).reverse().toString().toCharArray()) {
            if (c != '-') {
                if (counter == k) {
                    counter = 0;
                    result.append(batch);
                    /**
                     * Note: we don't have to care if an excessive trailing dash is added
                     * because we enter into this block when another character is on the way, and the
                     * previous block was completed. So if we end up exactly with k-size batch, this
                     * will not be processed here, but outside this block below
                     */
                    result.append('-');
                    batch.delete(0, batch.length());
                }
                batch.append(c);
                counter++;
            }
        }

        if (batch.length() > 0) result.append(batch);
        result.reverse();
        return result.toString().toUpperCase();
    }
}
