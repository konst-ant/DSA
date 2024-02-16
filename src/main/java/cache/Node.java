package cache;

public class Node<V> {
    public Node<V> next;
    public V value;

    public Node(V value) {
        this.value = value;
    }

    public Node(Node<V> next, V value) {
        this.next = next;
        this.value = value;
    }
}
