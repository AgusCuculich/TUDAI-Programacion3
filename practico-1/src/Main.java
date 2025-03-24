public class Main {
    public static void main(String[] args) {
        // 5) a)
        MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<>();
        list1.insertFront(30);
        list1.insertFront(22);
        list1.insertFront(20);
        list1.insertFront(15);
        list1.insertFront(10);

        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
        list2.insertFront(35);
        list2.insertFront(30);
        list2.insertFront(20);
        list2.insertFront(10);
        list2.insertFront(5);

        System.out.println(list1);
        System.out.println(list2);

        MySimpleLinkedList<Integer> comunes = elementosComunes(list1, list2);
        System.out.println(comunes);
    }

    public static MySimpleLinkedList<Integer> elementosComunes(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2) {
        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<>();
        // Creamos los iteradores de las listas que nos interesa comparar.
        LinkedListIterator<Integer> it1 = list1.iterator();
        LinkedListIterator<Integer> it2 = list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            int dif = it1.get().compareTo(it2.get());
            if (dif > 0) {
                it2.next();
            } else if (dif < 0) {
                it1.next();
            } else {
                // Como los elementos ya están ordenados, basta con insertarlos desde la última
                // posición para mantener el orden de la estructura.
                resultado.insertLast(it1.get());
                it1.next();
                it2.next();
            }
        }
        return resultado;
    }
}
