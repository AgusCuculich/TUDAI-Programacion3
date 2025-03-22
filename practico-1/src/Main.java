public class Main {
    public static void main(String[] args) {
        //        MySimpleLinkedList<Integer> numeros = new MySimpleLinkedList<>();
        //        numeros.insertFront(2);
        //        numeros.insertFront(5);
        //        numeros.insertFront(7);

        //        System.out.println(numeros.size());
        //        System.out.println(numeros);
        //        System.out.println(numeros.get(2));
        //        System.out.println(numeros.indexOf(7));

        MySimpleLinkedList<String> nombres = new MySimpleLinkedList<>();
        nombres.insertFront("pablo");
        nombres.insertFront("jimena");
        nombres.insertFront("nadaquever");

        System.out.println(nombres);
        System.out.println(nombres.size());
        System.out.println(nombres.indexOf("pablo"));
        System.out.println(nombres.get(1));

        
        // Iterator con WHILE
        /* LinkedListIterator<String> it = nombres.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/

        // Iterator con FOREACH
        // No es necesario instanciar un iterator ya que el propio foreach lo hace por nosotros.
        for(String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
