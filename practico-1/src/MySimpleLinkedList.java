public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> nuevoNodo = new Node<>(info,null);
        nuevoNodo.setNext(this.first);
        this.first = nuevoNodo;
        this.size+=1;
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

}