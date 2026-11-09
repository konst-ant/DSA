package faang.bitmanipulation;

/**
 * LC 191: Number of 1 Bits.
 * Count the number of set bits (Hamming weight) in the binary representation of an integer.
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(128));
        System.out.println(solution.hammingWeight(-3));
    }
}
