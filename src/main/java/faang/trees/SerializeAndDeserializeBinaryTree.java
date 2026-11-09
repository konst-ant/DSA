package faang.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 297: Serialize and Deserialize Binary Tree.
 * Design an algorithm to serialize a binary tree to a string and deserialize it back, O(n) time.
 * Precondition: the data passed to deserialize must not be null (null root/empty tree is a valid tree to serialize).
 */
public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Preorder traversal with an explicit "#" sentinel for null children makes the shape of the
    // tree reconstructible from a single pass of tokens (no lookahead or backtracking needed),
    // so both serialize and deserialize are O(n) time and O(n) space for the string/token buffer.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        Deque<String> tokens = new ArrayDeque<>();
        for (String token : data.split(",")) {
            tokens.addLast(token);
        }
        return deserializeHelper(tokens);
    }

    private TreeNode deserializeHelper(Deque<String> tokens) {
        String token = tokens.pollFirst();
        if (token == null || token.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeHelper(tokens);
        node.right = deserializeHelper(tokens);
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = solution.serialize(root);
        System.out.println(data);
        TreeNode restored = solution.deserialize(data);
        System.out.println(solution.serialize(restored));

        System.out.println(solution.serialize(solution.deserialize(solution.serialize(null))));
    }
}
