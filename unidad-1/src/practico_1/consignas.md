1&3.

````java
import practico_1.MySimpleLinkedList;

MySimpleLinkedList<Integer> numeros = new MySimpleLinkedList<>();
numeros.insertFront(2);
numeros.insertFront(5);
numeros.insertFront(7);

System.out.println(numeros.size());
System.out.println(numeros);
System.out.println(numeros.get(2));
System.out.println(numeros.indexOf(7));

MySimpleLinkedList<String> nombres = new MySimpleLinkedList<>();
nombres.insertFront("Pablo");
nombres.insertFront("Jimena");
nombres.insertFront("Tomás");

System.out.println(nombres);
System.out.println(nombres.size());
System.out.println(nombres.indexOf("pablo"));
System.out.println(nombres.get(1));
````

2.

4.

```java
import practico_1.LinkedListIterator;
import practico_1.MySimpleLinkedList;

MySimpleLinkedList<String> nombres = new MySimpleLinkedList<>();
nombres.insertFront("Pablo");
nombres.insertFront("Jimena");
nombres.insertFront("Tomás");

// Iterator con WHILE
LinkedListIterator<String> it = nombres.iterator();
while(it.hasNext()){
    System.out.println(it.next());
}

// Iterator con FOREACH
// No es necesario instanciar un iterator ya que el propio foreach lo hace por nosotros.
for(String nombre :nombres){
    System.out.println(nombre);
}
```

5) 
a)

````java
import practico_1.MySimpleLinkedList;

MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<>();
list1.insertFront(20);
list1.insertFront(22);
list1.insertFront(30);
list1.insertFront(10);
list1.insertFront(15);

MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
list2.insertFront(30);
list2.insertFront(5);
list2.insertFront(20);
list2.insertFront(10);
list2.insertFront(35);

System.out.println(list1);
System.out.println(list2);
````
b)

````java
import practico_1.LinkedListIterator;
import practico_1.MySimpleLinkedList;

public static void main(String[] args) {
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
````

6.

````java
import practico_1.MySimpleLinkedList;

public static void main(String[] args) {
    MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<>();
    list1.insertFront(20);
    list1.insertFront(22);
    list1.insertFront(30);
    list1.insertFront(10);
    list1.insertFront(15);

    MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
    list2.insertFront(30);
    list2.insertFront(5);
    list2.insertFront(20);
    list2.insertFront(10);
    list2.insertFront(35);

    System.out.println(list1);
    System.out.println(list2);

    MySimpleLinkedList<Integer> unicos = elementosUnicos(list1, list2);

    System.out.println(unicos);
}

public static MySimpleLinkedList<Integer> elementosUnicos(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2) {
    MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<>();
    Iterator<Integer> it1 = list1.iterator();

    while (it1.hasNext()) {
        Integer elem = it1.next();  // Guardamos la info del nodo y pasamos al sig
        if (!list2.contains(elem)) {
            resultado.insertFront(elem);
        }
    }
    return resultado;
}
````
