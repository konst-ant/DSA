package codility;


public class Task8_MaxCounters {

    public int[] solution(int N, int[] A) {

        // this is the number we had to be setting into all positions at last 'max counter' operation
        int maxCounterToAdd = 0;
        // this is the current maximum element out of all in array
        int currentMaxCounter = 0;

        int[] result = new int[N]; // all 0 initially

        for (int i = 0; i < A.length; i++) {
            if (A[i] < N + 1) {
                int index = A[i] - 1;
                result[index] = Math.max(result[index] + 1, maxCounterToAdd + 1);
                currentMaxCounter = Math.max(result[index], currentMaxCounter);
            } else {
                maxCounterToAdd = currentMaxCounter;
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(result[i], maxCounterToAdd);
        }
        return result;
    }

    public static void main(String[] args) {
        Task8_MaxCounters maxCounters = new Task8_MaxCounters();
        for (int i : maxCounters.solution(5, new int[] {3,4,4,6,1,4,4})) {
            System.out.println(i + " ");
        }
    }
}
