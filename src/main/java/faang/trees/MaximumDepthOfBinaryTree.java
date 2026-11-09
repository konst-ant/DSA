package faang.trees;

/**
 * LeetCode 104: Maximum Depth of Binary Tree.
 * Return the maximum depth (number of nodes along the longest path) of a binary tree, O(n) time.
 */
public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution.maxDepth(root));
        System.out.println(solution.maxDepth(new TreeNode(1)));
        System.out.println(solution.maxDepth(null));
    }
}
