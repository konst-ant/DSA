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
        TreeNode theMax = new TreeNode(Integer.MIN_VALUE);
        maxPathSum(root, theMax);
        return theMax.value;
    }

    public int maxPathSum(TreeNode node, TreeNode theMax) {
        int left = 0;
        int right = 0;

        if (node.left != null) left = maxPathSum(node.left, theMax);
        if (node.left != null) right = maxPathSum(node.right, theMax);

        theMax.value = Collections.max(
                Arrays.asList(node.value + left,
                        node.value + right,
                        node.value + left + right,
                        left,
                        right,
                        theMax.value));
        return Collections.max(
                Arrays.asList(node.value + left,
                        node.value + right));

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
