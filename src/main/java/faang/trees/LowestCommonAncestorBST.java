package faang.trees;

/**
 * LeetCode 235: Lowest Common Ancestor of a Binary Search Tree.
 * Find the lowest common ancestor of two given nodes in a BST, O(h) time.
 * Precondition: p and q must not be null (root may legitimately be null for an empty tree).
 */
public class LowestCommonAncestorBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            throw new IllegalArgumentException("p and q must not be null");
        }
        // The BST ordering property tells us which single child subtree can contain the LCA
        // (both targets smaller -> go left, both larger -> go right, otherwise we've found the
        // split point), so we only ever descend one path of length h. A general binary tree LCA
        // has no such ordering to exploit and needs an O(n) full-tree search instead.
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST solution = new LowestCommonAncestorBST();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left.left, root.left.right).val);
    }
}
