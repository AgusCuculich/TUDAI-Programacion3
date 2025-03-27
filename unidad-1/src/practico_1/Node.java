package practico_1;

public class Node<T> {
    /*
     * La <T> en public class Node<T> {} indica que la clase Node es genérica en Java.
     *
     * Node<Integer> intNode = new Node<>(10);  // Node con Integer
     * Node<String> stringNode = new Node<>("Hola");  // Node con String
     *
     * - Permite que la clase Node trabaje con diferentes tipos de datos sin necesidad de especificar un tipo concreto al momento de definirla.
     * - Se evita el uso de Object y conversiones manuales con cast.
     * */

    private T info;
    private Node<T> next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}