package codility;


/**
 * Drawing the picture representing discs as segments with center, left and right boundary, it's visible
 * through the array 0,1,..,N -  disc N-1 intersects with some subsequent disc Y if his right boundary is >=
 * than left boundary of Y. This is so because the centers of disc progress by 1 ascendingly.
 *
 */
public class Task17_NumberOfDiscs {

    private int leftBoundary(int i, int[] A) {
        return i - A[i];
    }

    private int rightBoundary(int i, int[] A) {
        return i + A[i];
    }

    // nested loop - not perfromant
    public int solution2(int[] A) throws Exception {

        int intersectCount=0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (rightBoundary(i, A) >= leftBoundary(j, A)) {
                    intersectCount++;
                }
            }
        }
        return intersectCount;
    }

    /**
     *
     * First build up array showing for each coordinate (that is index of array) - how many circles have started
     * at this coordinate, that is the same how many exists in this point
     *
     * Then with the second iteration through array, calculating the end of each disc, and referring to auxiliary
     * array we know how many discs intersecting with this one (because this is known at the right boundary of this
     * dis) and subtracting the index of current disc - not to account for the disc itself and all it's predecessors -
     * we get the number of intersections for current disk. Summing all up together we get the result
     *
      */
    public int solution(int[] A) throws Exception {
        int[] started = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int startPoint = i - A[i] > 0 ? i - A[i] : 0;
            started[startPoint]++;
        }

        int total = 0;
        for (int i = 0; i < started.length; i++) {
            total += started[i];
            started[i] = total;
        }

        int intersections=0;
        for (int i = 0; i < A.length; i++) {
            int endPoint = i + A[i] < started.length ? i + A[i] : started.length - 1;
            intersections += started[endPoint] - (i + 1);
        }
        return intersections;
    }

    public static void main(String[] args) throws Exception {
        Task17_NumberOfDiscs numberOfDiscs = new Task17_NumberOfDiscs();
//        System.out.println(numberOfDiscs.solution(new int[] {-3,1,2,-2,5,6}));
        System.out.println(numberOfDiscs.solution(new int[] {1,5,2,1,4,0}));
    }
}
