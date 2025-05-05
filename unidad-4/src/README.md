# HashMap<K, V>
Provides the basic implementation of the Map interface in Java. HashMap stores data in (key, value) pairs. Each key is associated with a value, and you can access the value by using the corresponding key.

* Internally uses Hashing (similar to Hashtable in Java).
* Not synchronized (unlike Hashtable in Java) and hence faster for most of the cases.
* Allows to store the null keys as well, but there should be only one null key object, and there can be any number of null values.
* Duplicate keys are not allowed in HashMap, if you try to insert the duplicate key, it will replace the existing value of the corresponding key.
* HashMap uses keys in the same way as an Array uses an index.
* HashMap allows for efficient key-based retrieval, insertion, and removal with an average O(1) time complexity.

````java
public class HashMap<K, V> 
    extends AbstractMap<K, V>
    implements Map<K, V>, Cloneable, Serializable
````

> [!NOTE]
> 
> Map es una interfaz
> * Define el comportamiento general de un diccionario (estructura que almacena pares clave-valor).
> * Proporciona los métodos que todas las implementaciones deben tener, como:
put(), get(), remove(), containsKey(), etc.
> 
> HashMap es una clase concreta que implementa la interfaz Map
> * Usa una tabla hash interna para organizar los datos, lo que permite acceder a los valores rápidamente por clave.
> 
> En conclusión: 
> 
> Map es el qué: define qué operaciones puede hacer un mapa (guardar pares clave-valor, obtener valores, etc).
> 
> HashMap es el cómo: implementa esas operaciones de una forma concreta (usando una tabla hash, sin orden).

### Operaciones básicas
* **`put(K key, V value)`** – Asocia el valor a la clave (sobrescribe si ya existe).
* **`get(Object key)`** – Devuelve el valor asociado a la clave.
* **`remove(Object key)`** – Elimina la entrada por clave.
* **`containsKey(Object key)`** – Verifica si existe una clave.
* **`containsValue(Object value)`** – Verifica si existe un valor.
* **`size()`** – Número de pares clave-valor.
* **`isEmpty()`** – Verifica si está vacío.
* **`clear()`** – Borra todo el contenido.

### Iteración y vistas
* **`keySet()`** – Devuelve un Set<K> con todas las claves.
* **`values()`** – Devuelve una Collection<V> con todos los valores.
* **`entrySet()`** – Devuelve un Set<Map.Entry<K,V>> con todas las entradas (clave-valor).

> [!NOTE]
> * Un **Set** es una colección que no permite elementos duplicados.
> * **Collection** es la interfaz raíz para todas las colecciones en Java (listas, sets, colas, etc.). Incluye los métodos comunes: add(), remove(), size(), contains(), isEmpty().
> * Un **Map.Entry<K, V>** representa una entrada (clave-valor) en un Map como HashMap.
> 
> Dispone de métodos como:
> * **`getKey()`** – obtiene la clave
> * **`getValue()`** – obtiene el valor
> * **`setValue(V value)`** – cambia el valor
> 
> Se usa comúnmente en bucles para recorrer un Map:
> ````java
> Map<String, Integer> edades = new HashMap<>();
> edades.put("Juan", 30);
> edades.put("Ana", 25);
> 
> for (Map.Entry<String, Integer> entry : edades.entrySet()) {
> System.out.println(entry.getKey() + " tiene " + entry.getValue() + " años");
> }
> ````

### Métodos útiles
* **`getOrDefault(Object key, V defaultValue)`** - Devuelve el valor asociado a la clave si existe, o el valor por defecto si no.
* **`putIfAbsent(K key, V value)`** - Si no existe la clave, la añade con el valor dado. Si existe, no la sobrescribe.
* **`replace(K key, V value)`** - Reemplaza el valor solo si la clave existe.

# LinkedList<E>
This class is an implementation of the LinkedList data structure which is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part. The elements are linked using pointers and addresses and each element is known as a node. 

````java
public class LinkedList<E>
    implements List<E>, Deque<E>, Queue<E>, Collection<E>, Iterable<E>
````

### Métodos de List<E> (funciona como lista por índice)
* **`add(E e)`** – Añade al final.
* **`add(int index, E e)`** – Inserta en una posición específica.
* **`get(int index)`** – Obtiene el elemento en ese índice.
* **`set(int index, E e)`** – Reemplaza el valor en ese índice.
* **`remove(int index)`** – Elimina el elemento en ese índice.
* **`indexOf(Object o)`** – Devuelve el primer índice de un objeto.
* **`lastIndexOf(Object o)`** – Devuelve el último índice de un objeto.
* **`size()`**, **`isEmpty()`**, **`clear()`** – Tamaño, si está vacía, borrar todo.

### Métodos de Deque<E> (doble cola: añade y elimina por ambos extremos)
* **`addFirst(E e)`** – Añade al principio.
* **`addLast(E e)`** – Añade al final.
* **`getFirst()`** – Devuelve el primer elemento (sin quitarlo).
* **`getLast()`** – Devuelve el último elemento (sin quitarlo).
* **`removeFirst()`** – Quita el primero.
* **`removeLast()`** – Quita el último.
* **`offerFirst(E e)`** – Intenta añadir al principio, devuelve true/false.
* **`offerLast(E e)`** – Intenta añadir al final.
* **`pollFirst()`** – Devuelve y elimina el primero, o null si está vacío.
* **`pollLast()`** – Devuelve y elimina el último, o null.

### Métodos de Queue<E> (comportamiento tipo FIFO)
* **`offer(E e)`** – Añade al final (cola).
* **`poll()`** – Elimina y devuelve el primero (o null si vacío).
* **`peek()`** – Devuelve el primero sin eliminarlo

### Otros métodos útiles
* **`contains(Object o)`** – Verifica si contiene un objeto.
* **`iterator()`** – Iterador desde el inicio.
* **`descendingIterator()`** – Iterador en orden inverso.