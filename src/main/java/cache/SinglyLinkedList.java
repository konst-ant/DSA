package struct;


import java.util.Iterator;

public class SinglyLinkedList<V> implements Iterable<V> {
    // sentinels
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.next = this.tail;
        this.size = 0;
    }

    /**
     * adding new elements to the tail - actually by reusing existing tail that will become new node
     * and attaching new tail
     * @param value
     */
    public void add(V value) {
        Node<V> newTail = new Node<>(null);
        tail.next = newTail;
        tail.value =value;
        tail = newTail;
        size++;
    }

    public V remove(V value) {
        if (value == null) return null;

        Node<V> node = head.next;
        while (node != tail) {
            if (value.equals(node.value)) {
                return remove(node);
            }
            node = node.next;
        }
        return null;
    }

    private V remove(Node<V> node) {
        V value = node.value;
        if (node.next == tail) {
            tail = node;
        }
        node.value = node.next.value;
        node.next = node.next.next;
        size--;
        return value;
    }

    public V removeFirst() {
        if (head.next != tail) {
            return remove(head.next);
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new ValueIterator();
    }

    private class ValueIterator implements Iterator<V> {
        Node<V> start = SinglyLinkedList.this.head;
        Node<V> end = SinglyLinkedList.this.tail;

        public boolean hasNext() {
            return start.next != end;
        }
        public V next() {
            start = start.next;
            return start.value;
        }
        public void remove() { throw new UnsupportedOperationException("remove not supported"); }
    }
}
