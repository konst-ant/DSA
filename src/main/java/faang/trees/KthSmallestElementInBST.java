package faang.trees;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LeetCode 230: Kth Smallest Element in a BST.
 * Find the kth smallest value in a binary search tree using iterative in-order traversal, O(h + k) time.
 * Precondition: root must not be null and k must be a positive integer no greater than the tree's node count.
 */
public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException("root must not be null");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k must be positive");
        }
        // Iterative in-order traversal: the stack only ever holds the current root-to-node path
        // (at most h ancestors), so we stop as soon as we've popped the kth node instead of
        // building the full in-order list first. That keeps space at O(h) rather than O(n).
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count++;
            if (count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        throw new IllegalArgumentException("k is out of bounds");
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(solution.kthSmallest(root, 3));
        System.out.println(solution.kthSmallest(root, 1));
        System.out.println(solution.kthSmallest(root, 6));
    }
}
