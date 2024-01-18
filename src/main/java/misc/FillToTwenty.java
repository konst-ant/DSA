package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Find how to compose a set of 8 odd numbers, which in sum give 20.
 * Print all combinations
 *
 * @author Konstantin Antipin</a>
 *
 */
public class FillToTwenty {

    private static final int SUM = 20;
    private static final int NUMBERS_TOTAL = 8;

    LinkedList<ArrayList<Integer>> deque = new LinkedList<>();

    // Note: the numbers are probed in reverse order - try filling with biggest one first
    int[] alphabet = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    public static void main(String[] args) {
        FillToTwenty task = new FillToTwenty();
        task.initDeque();
        task.search();
    }

    /**
     * Put in dequeue initial candidate sequences {19}, {17}, {15} ...
     */
    protected void initDeque() {
        for (int k=0; k<alphabet.length; k++) {
            ArrayList<Integer> startCandidate = new ArrayList<>(8);
            startCandidate.add(alphabet[k]);
            deque.addFirst(startCandidate);
        }
    }

    /**
     * Read next candidate sequence from the beginning of dequeue
     * and process it:
     * - if sequence is filled, check the sum and print successful ones
     * - if sequence is not full, try to extend it with ints, which are smaller or equal the right-most one
     */
    protected void search() {
        ArrayList<Integer> next;
        // Count how many enqueue iterations we do in total
        int numberOfEnqueues = alphabet.length;
        while (deque.size() > 0) {
            // Get next candidate from beginning
            next = deque.removeFirst();

            if (next.size() == NUMBERS_TOTAL) {
                // Candidate filled, validate it right away and print out if successful
                if (validateCandidate(next) == 0) {
                    System.out.println("Valid sequence: " + next);
                }
            } else {
                // Generate and queue new candidates
                int last = next.get(next.size()-1);
                int startIndex = Arrays.binarySearch(alphabet, last);
                for (int k = 0; k<=startIndex; k++) {
                    ArrayList<Integer> extent = new ArrayList(next);
                    extent.add(alphabet[k]);
                    // Only enqueue if the sum is not exceeded
                    if (validateCandidate(extent) <= 0) {
                        deque.addFirst(extent);
                        numberOfEnqueues++;
                    }
                }
            }
        }
        System.out.printf("Totally enqueued %d times\n", numberOfEnqueues);
    }

    /**
     * Sums up candidate members and returns -1, 0, 1 if the sum is below, equals or above SUM corr-ly
     *
     * @param candidate
     * @return
     */
    protected int validateCandidate(ArrayList<Integer> candidate) {
        int sum=0;
        for(int i: candidate) {
            sum +=i;
        }
        if (sum < SUM) {
            return -1;
        } else if (sum == SUM) {
            return 0;
        } else {
            return 1;
        }
    }

}
