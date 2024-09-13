
public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;
        public Node(Node<T> prev, T element, Node<T> next){
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    public void add(T value) {
        Node<T> newElement = new Node<>(last, value, null);
        if(last != null) {
            last.next = newElement;
        }
        last = newElement;
        if(first == null) {
            first = newElement;
        }
        size++;
    }

    public void clear() {
        Node<T> current = first;
        for(int i = 0; i < size - 1; i++) {
            current = current.next;
            current.prev = null;
        }
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return first.element;
    }

    public T poll() {
        T element = first.element;
        if(first.next != null) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
        }
        size--;
        return element;
    }
}
