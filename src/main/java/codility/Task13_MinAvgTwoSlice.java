package codility;

/**
 * To find minimum average of all possible slices we will need to consider only 2-size and 3-size slices.
 * This is because of the following:
 * 1. 2-size slices are elementary, will need to consider them anyway
 * 2. We can not say that for a 3-size slice the task can be brought down to finding minimum average 2-size slice within
 * that slice, because it can be that minimum average for 3-size slice is less than minimum average than it's
 * constituent 2-size slices. For example, here {1, 10, 1} - it's 4 is < 5,5.
 * That said, it means we will need to consider all 3-size slices as well
 * 3. For a big slice of arbitrary size it's minimum average slice will be the minimum average out of it's
 * possible 2,3-size slices
 * To prove that let's consider that we found a 2-size or 3-size slice within big slice which is minimum average
 * among all possible 2,3-size slices. Let's suppose we have expressed the big slice in terms of 2-size and 3-size
 * slices fully and one slice out of that set is our minimum average 2-size or 3-size slice that was found
 * (we can always do so with 2,3 size slices). If out of remaining 2,3-size slices except minimum average found
 * at lease one has average that is less than average of a big slice, than our minimum average slice that was found
 * is less than big slice average by definition as it is smaller than any other 2,3-slice. Otherwise, if all
 * remaining 2,3-size slice averages are greater than average of a big slice then our found minimum average slice
 * should be less than average of a big slice. If it was not so then all of 2,3-slices constituting a big slice
 * would have their averages more than a big slice average, that obviously can not be because each then it would be
 * equivalent as if each element of big slice bring into total sum a portion bigger than average of a big slice,
 * in summary giving the overall sum of a big slice bigger than it is.
 * So, in conclusion any big slice of size more than 3 can not have it's average value lower than the minimum
 * average of all possible constituent 2,3-size slices
 */
public class Task13_MinAvgTwoSlice {

    public int solution(int[] A) {

        double minSlice = Integer.MAX_VALUE;
        int minSlicePosition = 0;

        for (int i = 0; i < A.length - 1; i++) {
            // get avg for next 2-size slice
            double avg = ((double) (A[i] + A[i + 1])) / 2;
            if (minSlice > avg) {
                minSlice = avg;
                minSlicePosition = i;
            }

            // get avg for next 3-size slice
            if (i < A.length - 2) {
                avg = ((double)(A[i] + A[i + 1] + A[i+2])) / 3;
                if (minSlice > avg) {
                    minSlice = avg;
                    minSlicePosition = i;
                }
            }
        }

        return minSlicePosition;
    }

    public static void main(String[] args) {
        Task13_MinAvgTwoSlice minAvgSlice = new Task13_MinAvgTwoSlice();
//        System.out.println(minAvgSlice.solution(new int[] {4,2,2,5,1,5,8}));
        System.out.println(minAvgSlice.solution(new int[] {7,6,5,4,3,2,9}));
    }
}
