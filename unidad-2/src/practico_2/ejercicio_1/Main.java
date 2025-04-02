package practico_2.ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Tree arbol = new Tree();
        // Árbol 1
        /*arbol.add(5);
        arbol.add(2);
        arbol.add(10);
        arbol.add(1);*/

        // Árbol 2
        /*arbol.add(6);
        arbol.add(2);
        arbol.add(1);
        arbol.add(4);
        arbol.add(10);
        arbol.add(8);
        arbol.add(7);
        arbol.add(9);
        arbol.add(11);*/

        // Árbol 3
        /*arbol.add(6);
        arbol.add(2);
        arbol.add(1);
        arbol.add(4);
        arbol.add(3);
        arbol.add(8);*/

        // Árbol 4
        arbol.add(10);
        arbol.add(5);
        arbol.add(2);
        arbol.add(30);
        arbol.add(25);
        arbol.add(45);

        /*System.out.println(arbol.getElemAtLevel(1));
        System.out.println(arbol.getFrontera());
        System.out.println(arbol.getHeight());*/
        arbol.printPreOrden();
        System.out.println('\n');
        arbol.delete(10);
        arbol.printPreOrden();
        //System.out.println(arbol.collectLeavesAbove(20));
        //System.out.println(arbol.sumInternalNodes());
    }
}
