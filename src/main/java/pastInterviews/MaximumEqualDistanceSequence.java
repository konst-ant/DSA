package pastInterviews;

import java.util.Arrays;

/**
 * Solution from Codility for the task for Atlassian:
 * given array int[] A of positive integer (non less than 2 elements in array), return the longest number of elements in
 * array which make constant distance between their elements. The distance could be 0.
 *
 * Don't worry about performance in this task
 *
 */
public class MaximumEqualDistanceSequence {


    public int solution(int[] A) {
        Arrays.sort(A);

        int count = 1;
        int maxCount = 0;

        for (int i=0; i < A.length - 1; i++) {
            int catRear = i;
            int catFront = i + 1;

            int diff = diff(A, catRear + 1, catRear);
            while (catRear < A.length - 1 && catFront < A.length) {
                if (diff(A, catFront, catRear) == diff) {
                    count++;
                    catRear++;
                    catFront++;
                } else {
                    catFront++;
                }
            }
            maxCount = Math.max(count, maxCount);
            count=1;
        }

        return maxCount;
    }

    public int diff(int[] A, int frontIndex, int rearIndex) {
        return A[frontIndex] - A[rearIndex];
    }

    public static void main(String[] args) {
        MaximumEqualDistanceSequence meds = new MaximumEqualDistanceSequence();
//        System.out.println(template.solution(new int[] { 4, 3, 5, 1, 4, 4, 4}));
        System.out.println(meds.solution(new int[] { 3, 22, 16, 2, 20, 18, 1, 5, 4, 4, 4}));
    }

}
