package codility;


public class Task6_TapeEquilibrium {

    public int solution(int[] A) {
        int sum =0;

        // sum all but the first: first becomes - the left part, the rest - the right part
        for (int i=1; i<A.length; i++) {
            sum += i;
        }

        int leftPartSum = A[0];
        int rightPartSum = sum;
        int min_difference = Math.abs(leftPartSum - rightPartSum);
        for (int i=1; i<A.length; i++) {
            leftPartSum += i;
            rightPartSum -= i;
            min_difference = Math.min(min_difference, Math.abs(leftPartSum - rightPartSum));
        }
        return min_difference;
    }

    public static void main(String[] args) {
        Task6_TapeEquilibrium tapeEquilibrium = new Task6_TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(new int[] {3,1,2,4,3}));

    }
}
