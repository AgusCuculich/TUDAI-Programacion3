package practico_1;

public class MySimpleLinkedList<T> implements Iterable<T>, Comparable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> nuevoNodo = new Node<>(info,null);
        nuevoNodo.setNext(this.first);
        this.first = nuevoNodo;
        this.size++;
    }

    public void insertLast(T info) {
        Node<T> nuevoNodo = new Node<>(info, null);
        if(this.last == null) {
            // Si la lista está vacía fist y last deben apuntar al nuevo nodo.
            this.first = nuevoNodo;
            this.last = nuevoNodo;
        } else {
            // Como last siempre guarda la última posicion, si se añade un nuevo nodo, hacemos que este apunte al viejo
            // last y se posicione último en la lista.
            this.last.setNext(nuevoNodo);
            this.last = nuevoNodo;
        }
        this.size++;
    }

    public T extractFront() {
        Node<T> nodoActual = this.first;
        Node<T> nodoSiguiente = this.first.getNext();
        this.first = nodoSiguiente;
        this.size-=1;
        return nodoActual.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {

        if (index >= this.size || index < 0){
            throw new IllegalArgumentException();
        }

        Node<T> nodoActual = this.first;
        int contador = 0;

        while (contador < this.size){
            if (contador == index){
                return nodoActual.getInfo();
            }
            nodoActual = nodoActual.getNext();
            contador++;
        }

        return null;

    }

    public int indexOf(T info){
        int contador = 0;
        Node<T> nodoActual = this.first;

        while (contador < this.size){
            if (nodoActual.getInfo().equals(info)){
                return contador;
            }
            contador++;
            nodoActual = nodoActual.getNext();
        }

        return -1;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String resultado = "";
        Node<T> nodoActual = this.first;
        while (nodoActual != null){
            resultado +=  nodoActual.getInfo() + " - ";
            nodoActual = nodoActual.getNext();

        }

        return resultado;
    }

    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<>(this.first);
    }

    public int compareTo(T elemento) {
        return this.compareTo(elemento);
    }

    public boolean contains(T elemento) {
        // Creamos un puntero que apunte hacia el primer elemento de la lista.
        Node<T> actual = this.first;
        while (actual != null) {
            // Recorre cada nodo para verificar si su info coincide con la del elemento.
            if (actual.getInfo().equals(elemento)) {
                return true;  // Se encontró una coincidencia
            }
            actual = actual.getNext();
        }
        return false;  // No se encontró una coincidencia
    }
}