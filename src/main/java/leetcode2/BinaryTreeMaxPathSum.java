package leetcode2;

import java.util.Arrays;
import java.util.Collections;


/**
 * Find the maximum path sum in a Binary Tree.
 * Nodes of the tree store Integer values (can be both positive and negative).
 *
 * The path is defined as any sequence of connected nodes of the Binary Tree.
 *
 *
 */
public class BinaryTreeMaxPathSum {

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree cannot be null");
        }

        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSum(node.left, max));
        int right = Math.max(0, maxPathSum(node.right, max));

        // Maximum path that uses both branches (or neither)
        int currentMax = node.value + left + right;

        max[0] = Math.max(max[0], currentMax);

        // Maximum single-branch path that can be extended by the parent
        return node.value + Math.max(left, right);
    }

    public void run(TreeNode root) {
        System.out.println(maxPathSum(root));
    }


    public static void main(String[] args) {
        BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
        binaryTreeMaxPathSum.run(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        binaryTreeMaxPathSum.run(new TreeNode(-1, new TreeNode(2), new TreeNode(3)));
        binaryTreeMaxPathSum.run(new TreeNode(-2, new TreeNode(2), new TreeNode(3)));
        binaryTreeMaxPathSum.run(new TreeNode(-3, new TreeNode(2), new TreeNode(3)));
        // has to be 16 from the right subtree
        binaryTreeMaxPathSum.run(new TreeNode(-3,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))));
    }
}
