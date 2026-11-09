package faang.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 155: Min Stack.
 * Design a stack supporting push, pop, top, and retrieving the minimum element, all in O(1) time.
 * Precondition: pop(), top(), and getMin() require the stack to be non-empty; calling them on an
 * empty stack throws IllegalStateException rather than failing on an internal empty-deque access.
 */
public class MinStack {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        requireNonEmpty();
        stack.pop();
        minStack.pop();
    }

    public int top() {
        requireNonEmpty();
        return stack.peek();
    }

    public int getMin() {
        requireNonEmpty();
        return minStack.peek();
    }

    private void requireNonEmpty() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        // edge case: operating on an empty stack throws rather than failing silently
        minStack.pop();
        minStack.pop();
        try {
            minStack.getMin();
        } catch (IllegalStateException e) {
            System.out.println("Expected failure on empty stack: " + e.getMessage());
        }
    }
}
