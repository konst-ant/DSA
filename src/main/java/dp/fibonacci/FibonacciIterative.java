package dp.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * return n-th Fibonacci number
 *
 */
public class FibonacciIterative {
    public static int solution(int number) {
        int[] sequence = new int[number];
        if (number <= 2) {
            return number - 1;
        }
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[number-1];
    }

    public static int solutionStorageOptimized(int number) {
        if (number <= 2) {
            return number - 1;
        }
        int n1 = 0;
        int n2 = 1;
        int index = 2;
        while (index < number){
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
            index++;
        }
        return n2;
    }


    public static void main(String[] args) {
        System.out.println(solution(20));
        System.out.println(solutionStorageOptimized(20));
    }
}
