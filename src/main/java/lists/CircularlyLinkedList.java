package lists;


/**
 *
 * This inspired from Tamassia. Basically we can keep in implementation only 'last' pointer.
 *
 * Implement the singly circularly linked list:
 *
 * public class CircularlyLinkedList<E> {
 * 	public E first() {
 *        }
 *
 * 	public E last() {
 *    }
 *
 * 	public void rotate() {
 *    }
 *
 * 	public void addFirst(E e) {
 *    }
 *
 * 	public void addLast(E e) {
 *    }
 * }
 *
 */

public class CircularlyLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size;

    public CircularlyLinkedList() {
        head = null;
        size = 0;
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return last.data;
    }

    public void rotate() {
        if (head != null) {
            last = last.next;
            head = head.next;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            newNode.next = newNode;
            last = newNode;
            head = newNode;
        } else {
            Node<E> current = head;
            //last.next = newNode;
//			newNode.next = head;
//			//last = newNode;
//			//last.next = head;
//			Node<E> current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;

            current.next = newNode;
            last = current;
            head = newNode;
        }
        //head =newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            newNode.next = newNode;
            head = newNode;

        } else {
            Node<E> current = head;
            while (current.next != head) {
                current = current.next;
            }

            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());

        list.rotate();
        System.out.println("After rotation:---");
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());

        list.rotate();
        System.out.println("After rotation:---");
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
    }
}
