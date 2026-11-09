package faang.trees;

/**
 * LeetCode 98: Validate Binary Search Tree.
 * Determine whether a binary tree satisfies the binary search tree property, O(n) time.
 */
public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        TreeNode valid = new TreeNode(2);
        valid.left = new TreeNode(1);
        valid.right = new TreeNode(3);
        System.out.println(solution.isValidBST(valid));

        TreeNode invalid = new TreeNode(5);
        invalid.left = new TreeNode(1);
        invalid.right = new TreeNode(4);
        invalid.right.left = new TreeNode(3);
        invalid.right.right = new TreeNode(6);
        System.out.println(solution.isValidBST(invalid));

        System.out.println(solution.isValidBST(new TreeNode(1)));
        System.out.println(solution.isValidBST(null)); // empty tree edge case -> true
    }
}
