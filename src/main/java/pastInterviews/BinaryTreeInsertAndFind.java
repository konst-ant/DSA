package pastInterviews;

/**
 * Solution from Codility for the task for Atlassian:
 * given class Node of binary search tree, implement constructor -  public Node(int[] numbers), and
 * method - public boolean find(int value)
 */
public class BinaryTreeInsertAndFind {


    class Node {
        public Integer value;
        public Node left;
        public Node right;

        Node root = null;

        public Node() {
        }

        public Node(int[] numbers)
        {
            for (int i : numbers) {
                root = insert(root, i);
            }
            // YOUR SOLUTION HERE
        }

        public Node insert(Node root, int value) {
            if (root == null) {
                root = new Node();
                root.value = value;
                return root;
            }

            if (value < root.value)
                root.left = insert(root.left, value);
            else if (value > root.value)
                root.right = insert(root.right, value);

            return root;
        }

        public boolean find(int value)  {
            root = findInternal(root, value);
            if (root!= null)
                return true;
            else
                return false;
        }

        // recursive find
        public Node findInternal(Node root, int value)  {
            if (root==null || root.value==value)
                return root;
            if (root.value > value)
                return findInternal(root.left, value);

            return findInternal(root.right, value);
        }
    }
    public boolean solution(int[] numbers, int nrToFind) {
        return new Node(numbers).find(nrToFind);
    }

    public static void main(String[] args) {
        BinaryTreeInsertAndFind binaryTreeInsertAndFind = new BinaryTreeInsertAndFind();
        System.out.println(binaryTreeInsertAndFind.solution(new int[]{5, 10, 3, 9, 1, 20}, 9));
    }

}
