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
    }
}
