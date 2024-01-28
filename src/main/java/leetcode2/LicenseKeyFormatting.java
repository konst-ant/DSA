package leetcode2;


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
        System.out.println(licenseKeyFormatting.reformat("abcd-efgh-ijkl-mnop", 7)) ;
        System.out.println(licenseKeyFormatting.reformat("abcd-efgh-ijkl-mnop", 2)) ;
        System.out.println(licenseKeyFormatting.reformat("abcd-efgh-ijkl-mnop", 3)) ;
        System.out.println(licenseKeyFormatting.reformat("abcd-efgh-ijkl-mnop", 4)) ;
    }

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
