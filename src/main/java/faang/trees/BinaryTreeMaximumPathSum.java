package faang.trees;

/**
 * LeetCode 124: Binary Tree Maximum Path Sum.
 * Find the maximum path sum between any two nodes in a binary tree, O(n) time.
 * Precondition: root must not be null (the tree must contain at least one node).
 */
public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("root must not be null");
        }
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        System.out.println(solution.maxPathSum(t1));

        TreeNode t2 = new TreeNode(-10);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(20);
        t2.right.left = new TreeNode(15);
        t2.right.right = new TreeNode(7);
        System.out.println(solution.maxPathSum(t2));

        System.out.println(solution.maxPathSum(new TreeNode(-3)));
    }
}
