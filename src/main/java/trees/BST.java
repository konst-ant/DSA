package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The proper Binary Search Tree (BS) is a binary tree keeping a value in each node of the tree, and
 * satisfying the condition:
 *
 * Let L & R be left and right subtrees for any node N of the tree.
 * If L exists, then the value of each node of L is less than or equal to the value of N.
 * If R exists, then the value of each node of R is greater than the value of N.
 *
 * Given the binary tree of integers:
 *
 * 1. write a method that checks if it is a proper BST.
 * boolean isBST(Node root)
 *
 * 2. write a method which given some Node in a proper BST returns the next in order bigger value stored in the tree or -1 if no such value
 * int nextInOrderBigger(Node node);
 *
 * 3. write a method to print out BST values in order
 * void inOrderTraversal(Node root);
 *
 * 4. write a method calculating the height of the tree (the height of the tree is the number of nodes in it's most long branch)
 * int height(Node root);
 *
 * 5. write a method to check if the binary tree is balanced.
 * public boolean isBalanced(Node n)
 *
 *        5
 *     /    \
 *    2      7
 *  /  \   /   \
 * 1   5  6     8
 *
 *
 */
public class BST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }

        public boolean isExternal() {
            if (left == null && right == null) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        Node someNode;

        Node root = new Node(5);
        Node left = new Node(2);
        Node right = new Node(7);
        root.left = left;
        root.right = right;
//        someNode = right;
        left.parent = root;
        right.parent = root;

        left = new Node(1);
        right = new Node(3);
        someNode = right;
//        someNode = left;
        root.left.left = left;
        root.left.right = right;
        left.parent = root.left;
        right.parent = root.left;

        left = new Node(6);
        right = new Node(8);
//        someNode = right;
        root.right.left = left;
        root.right.right = right;
        left.parent = root.right;
        right.parent = root.right;

        BST bst = new BST();
        System.out.println("Is proper tree " + bst.isProperBST2(root));
        System.out.println("Next in order bigger: " + bst.nextInOrderBigger(someNode));
        System.out.println("In order traversal: " + bst.inOrderTraversal(root).stream().map(n -> {return n.value;}).collect(Collectors.toList()).toString());
        System.out.println("Tree height (good algo): " + bst.height(root));
        System.out.println("Depth for some node: " + bst.depth(someNode));
        System.out.println("Tree height (bad algo): " + bst.heightBad(root));


        Node isBalanced = new Node(5);
        Node left2 = new Node(2);
        Node right2 = new Node(7);
        isBalanced.left = left2;
        isBalanced.right = right2;

        left2 = new Node(1);
        right2 = new Node(3);
        isBalanced.left.left = left2;
//        isBalanced.left.right = right2;
        isBalanced.left.left.left = right2;

        left2 = new Node(6);
        right2 = new Node(8);
        isBalanced.right.left = left2;
        isBalanced.right.right = right2;
        System.out.println("Balanced: " + bst.isBalanced(isBalanced));
    }

    public boolean isBalanced(Node n) {
        if (balancedHeight(n) > -1) {
            return true;
        }
        return false;
    }

    private int balancedHeight(Node n) {
        if (n == null) {
            return 0;
        }

        int h1 = balancedHeight(n.left);
        int h2 = balancedHeight(n.right);

        if (h1 == -1 || h2 == -1) {
            return -1;
        }
        if (Math.abs(h1 - h2) > 1) {
            return -1;
        }
        if (h1 > h2) {
            return h1 + 1;
        } else {
            return h2 + 1;
        }
    }

    public boolean isProperBST2(Node root) {
        return isProperBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isProperBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value < min || node.value > max) {
            return false;
        }

        return isProperBST(node.left, min, node.value) && isProperBST(node.right, node.value + 1, max);
    }

    /**
     * Incorrect implementation, because it doesn't account for the smallest leave in the subtree,
     * but only for the direct child, meaning
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean isProperBST2(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.left.value > node.value || node.value <= node.right.value) {
            return false;
        }

        return isProperBST2(node.left, -1, -1) && isProperBST2(node.right, -1, -1);
    }

    public int nextInOrderBigger(Node node) {
        int result = getLeftMostNodeValue(node.right);
        if (result == -1) {

            // if this is root node, nothing to search
            if (node.parent == null) {
                return -1;
            }

            // traverse up to the root
            Node current = node;
            Node parent = node.parent;
            while (parent != null) {
                if (parent.left == current) {
                    // our node is to the left from parent - there are potentially bigger values
                    // so we try there
                    if (parent.value > node.value) {
                        return parent.value;
                    } else if (parent.right != null) {
                        // as we can have equal values stored in left tree branches,
                        // the root value may be equal to node value.
                        // if so, get next value in the right branch of root
                        return getLeftMostNodeValue(parent.right);
                    }
                }
                current = parent;
                parent = parent.parent;
            }
        }
        return result;
    }

    private int getLeftMostNodeValue(Node node) {
        int result = -1;
        if (node != null) {
            Node tmp = node;
            do  {
                result = tmp.value;
                tmp = tmp.left;
            } while (tmp != null);
        }
        return result;
    }

    public List<Node> inOrderTraversal(Node root) {
        List<Node> positions = new ArrayList<>();
        inOrderTraversalInternal(root, positions);
        return positions;
    }

    private void inOrderTraversalInternal(Node node, List<Node> positions) {
        if (node == null) {
            return;
        }
        inOrderTraversalInternal(node.left, positions);
        positions.add(node);
        inOrderTraversalInternal(node.right, positions);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int h = 0;
        h = Math.max(h, 1 + height(root.left));
        h = Math.max(h, 1 + height(root.right));
        return h;
    }

    public int heightBad(Node root) {
        List<Node> positions = inOrderTraversal(root);
        int h = 0;
        for (Node n : positions) {
            if (n.isExternal()) {
                h = Math.max(h, depth(n));
            }
        }
        return h;
    }



    /**
     * Return the depth of the given node - that is how many ancestors from this node to the root,
     * including this node
     * @param node
     * @return
     */
    private int depth(Node node) {
        if (node == null) {
            return 0;
        }

        int d = 1;
        Node tmp = node;
        while (tmp.parent != null) {
            d++;
            tmp = tmp.parent;
        }
        return d;
    }



}
