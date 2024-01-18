package codility;


/**
 * If the array contained only positive integers, result would be the product of 3 biggest.
 * As we have negative integers too, we have to account possibility of two negatives multiplied by third positive,
 * which can deliver the maximum product.
 * Conclusion, we have to find 3 biggest positive digits plus two smallest negative (biggest by modulus negative)
 */
public class Task16_MaxProductOfThree {

    public int solution(int[] A) throws Exception {
        // both array ascending
        int[] biggestPositive = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] smallestNegative = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};


        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a > biggestPositive[2]) {
                biggestPositive[0] = biggestPositive[1];
                biggestPositive[1] = biggestPositive[2];
                biggestPositive[2] = a;
            } else if (a > biggestPositive[1]) {
                biggestPositive[0] = biggestPositive[1];
                biggestPositive[1] = a;
            } else if (a > biggestPositive[0]) {
                biggestPositive[0] = a;
            }

            if (a < 0 && a < smallestNegative[0]) {
                smallestNegative[1] = smallestNegative[0];
                smallestNegative[0] = a;
            } else if (a < 0 && a < smallestNegative[1]) {
                smallestNegative[1] = a;
            }
        }
        return Math.max(biggestPositive[0]*biggestPositive[1]*biggestPositive[2],
                biggestPositive[2]*smallestNegative[0]*smallestNegative[1]);
    }

    public static void main(String[] args) throws Exception {
        Task16_MaxProductOfThree maxProductOfThree = new Task16_MaxProductOfThree();
//        System.out.println(maxProductOfThree.solution(new int[] {-3,1,2,-2,5,6}));
        System.out.println(maxProductOfThree.solution(new int[] {-10,1,2,-2,5,6}));
    }
}
