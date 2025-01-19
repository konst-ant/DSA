package dp.knapsack.unbounded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumRibbonCutTabularTest {
    @Test
    public void shouldReturn2() {
        int[] pieces = new int[]{2,3,5};
        int sum = 5;
        MaximumRibbonCutTabular maximumRibbonCut = new MaximumRibbonCutTabular();
        assertEquals(2, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }

    @Test
    public void shouldReturn3() {
        int[] pieces = new int[]{3,5,7};
        int sum = 13;
        MaximumRibbonCutTabular maximumRibbonCut = new MaximumRibbonCutTabular();
        assertEquals(3, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }

    @Test
    public void shouldReturnAnother3() {
        int[] pieces = new int[]{2,3};
        int sum = 7;
        MaximumRibbonCutTabular maximumRibbonCut = new MaximumRibbonCutTabular();
        assertEquals(3, maximumRibbonCut.maximumAmountOfPieces(sum, pieces));
    }
}