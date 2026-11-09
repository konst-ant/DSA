package faang.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC 295: Find Median from Data Stream.
 * Maintains two heaps (max-heap for the lower half, min-heap for the upper half)
 * to return the running median in O(log n) per insertion.
 * Precondition: findMedian requires at least one number to have been added via addNum.
 */
public class FindMedianFromDataStream {

    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void addNum(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        } else {
            upper.offer(num);
        }
        // Rebalance so `lower` holds either the same count as `upper` or exactly one more;
        // that invariant is what makes findMedian() an O(1) peek instead of needing a scan.
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.isEmpty() && upper.isEmpty()) {
            throw new IllegalStateException("cannot compute median before any number is added");
        }
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2.0;
        }
        return lower.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream mf = new FindMedianFromDataStream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
