package dp.palindromic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Use same test for testing {@link LongestPalindrome} and {@link LongestPalindromeRecursive} and {@link LongestPalindromeBottomUp}
 */
class LongestPalindromeTest {

    @Test
    public void shouldReturn5() {
        LongestPalindromeBottomUp lp = new LongestPalindromeBottomUp();
        int result = lp.lp("abdbca");
        assertEquals(5, result);
    }

    @Test
    public void shouldReturn3() {
        LongestPalindromeBottomUp lp = new LongestPalindromeBottomUp();
        int result = lp.lp("cddpd");
        assertEquals(3, result);
    }

    @Test
    public void shouldReturn1() {
        LongestPalindromeBottomUp lp = new LongestPalindromeBottomUp();
        int result = lp.lp("pqr");
        assertEquals(1, result);
    }

}