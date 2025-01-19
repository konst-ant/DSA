package dp.unlimited;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumRibbonCutRecursiveTest {
    @Test
    public void shouldReturn2() {
        int[] pieces = new int[]{2,3,5};
        int sum = 5;
        MaximumRibbonCutRecursive maximumRibbonCut = new MaximumRibbonCutRecursive();
        assertEquals(2, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }

    @Test
    public void shouldReturn3() {
        int[] pieces = new int[]{3,5,7};
        int sum = 13;
        MaximumRibbonCutRecursive maximumRibbonCut = new MaximumRibbonCutRecursive();
        assertEquals(3, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }

    @Test
    public void shouldReturnAnother3() {
        int[] pieces = new int[]{2,3};
        int sum = 7;
        MaximumRibbonCutRecursive maximumRibbonCut = new MaximumRibbonCutRecursive();
        assertEquals(3, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }
}