package codility;

import java.util.HashMap;

public class NonDivisible {

    int[] solution(int[] A) {
        HashMap<Integer, Integer> countDistinct = new HashMap<>();
        for (int a : A) {
            int c = 0;
            if (countDistinct.containsKey(a)) {
                c = countDistinct.get(a);
            }
            c++;
            countDistinct.put(a, c);
        }

        HashMap<Integer, Integer> countDiv = new HashMap<>();
        for (int a : countDistinct.keySet()) {
            int counter = 0;
            for (int i = 1; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    if (countDistinct.containsKey(i)) {
                        counter += countDistinct.get(i);
                    }

                    if (i < Math.sqrt(a) && countDistinct.containsKey(a / i)) {
                        counter += countDistinct.get(a / i);
                    }
                }
            }
            countDiv.put(a, counter);
        }

        int[] result = new int[A.length];
        for (int j=0; j<A.length; j++) {
            result[j] = A.length - countDiv.get(A[j]);
        }

        return result;
    }

    public static void main(String[] args) {
        NonDivisible nonDivisible = new NonDivisible();
        int[] result = nonDivisible.solution(new int[] {3,1,2,3,6});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
