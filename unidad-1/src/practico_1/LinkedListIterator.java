package practico_1;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T>{
    private Node<T> current;

    public LinkedListIterator(Node<T> current) {
        this.current = current;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public T next() {
        T info = current.getInfo();
        this.current = this.current.getNext();
        return info;
    }

    // Devuelve la info del nodo actual sin pasar al sig.
    public T get() {
        return this.current.getInfo();
    }
}
