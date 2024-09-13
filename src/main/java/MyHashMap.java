
public class MyHashMap<K,T> {
    private int size = 0;
    private Node<K,T> first;
    private Node<K,T> last;

    private static class Node<K,T> {
        T element;
        K key;
        Node<K,T> next;
        public Node(K key, T element){
            this.key = key;
            this.element = element;
        }
    }

    public void put(K key, T value){
        if(first == null) {
            first = new Node<>(key, value);
            last = first;
        } else {
            last.next = new Node<>(key,value);
            last = last.next;
        }
        size++;
    }

    public void remove(K key) {
        if(first.key.equals(key)){
            if(first.next != null) {
                first = first.next;
            } else {
                first = null;
            }
        } else {
            Node<K, T> toRemove = first;
            for (int i = 0; i < size; i++) {
                toRemove = toRemove.next;
                if (toRemove.key.equals(key)) {
                    if (toRemove.next != null) {
                        Node<K, T> current = first;
                        int temp = i - 1;
                        for (int j = 0; j < temp; j++) {
                            current = current.next;
                        }
                        current.next = toRemove.next;
                    } else {
                        toRemove = null;
                    }
                    break;
                }
            }
        }
        size--;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    public T get(K key) {
            Node<K, T> current = first;
            for (int i = 0; i < size; i++) {
                if (current.key.equals(key)) {
                    return current.element;
                }
                current = current.next;
            }
            return null;
    }
}
