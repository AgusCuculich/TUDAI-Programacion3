package practico_2.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            // En caso de que no exista un nodo raíz, lo creamos con el valor pasado a la función.
            this.root = new TreeNode(value);
        else
            // Si la raíz existe, llamamos al método privado "add" para recorrer el árbol desde la raíz
            //  y añadir el nuevo nodo en la posición correspondiente.
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        // Evalua si el valor del nodo sobre el que estamos parados (actual) es mayor que el valor del elemento
        // que queremos insertar.
        if (actual.getValue() > value) {
            // Evalua si el nodo izq es null.
            if (actual.getLeft() == null) {
                // Creamos un nodo temporal y lo insertamos a la izq del actual.
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                // Recursión de la función desde el elemento izq del actual.
                add(actual.getLeft(),value);
            }
        // Evalua si el valor del nodo sobre el que estamos parados (actual) es menor que el valor del elemento
        // que queremos insertar.
        } else if (actual.getValue() < value) {
            // Evalua si el nodo der es null.
            if (actual.getRight() == null) {
                // Creamos un nodo temporal y lo insertamos a la der del actual.
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                // Recursión de la función desde el elemento der del actual.
                add(actual.getRight(),value);
            }
        }
    }

    // Devuelve el valor almacenado en el nodo raíz o null si el nodo no existe.
    public Integer getRoot() {
        return this.root != null ? this.root.getValue() : null;
    }

    // Informa si el árbol está vacío o no.
    public boolean isEmpty() {
        return this.root == null;
    }

    public Integer getMaxElem() {
        // Evalua si el árbol está vacío para no acceder a un espacio de memoria con null.
        if(this.isEmpty()) {
            return null;
        }
        // Creamos un nodo del que partir.
        TreeNode actual = this.root;
        // Buscamos el nodo cuyo nodo derecho sea null (máximo).
        while(actual.getRight() != null) {
            actual = actual.getRight();
        }
        // Retornamos el valor en el nodo hallado.
        return actual.getValue();
    }

    public boolean searchTraverse(TreeNode node, Integer value) {
        if(node == null) {
            return false;
        }
        if(node.getValue().equals(value)) {
            return true;
        }
        if (value < node.getValue()) {
            return searchTraverse(node.getLeft(), value);
        } else {
            return searchTraverse(node.getRight(), value);
        }
    }

    // Informa si un valor si encuentra o no dentro del árbol.
    public boolean hasElem(Integer value) {
        if(this.isEmpty()) {
            return false;
        }
        return searchTraverse(this.root, value);
    }

    /* Función anterior pero sin recursión.
    public boolean hasElem(Integer value) {
        // Nos aseguramos de que el árbol no esté vacío.
        if(this.isEmpty()) {
            return false;
        }
        TreeNode actual = this.root;
        // Si el valor buscado es mayor que el valor en raíz recorremos el lado derecho del árbol.
        if(value > this.getRoot()) {
            // Nos movemos a través del árbol hasta que el sig sea null o hasta que hallamos encontrado el valor buscado
            while(!actual.getValue().equals(value) && actual.getRight() != null) {
                actual = actual.getRight();
            }
            // Retornamos si el valor del nodo sobre el que estamos parados es igual al valor buscado.
            return actual.getValue().equals(value);
        }
        // Si el valor buscado es menor que el valor en raíz recorremos el lado izquierdo del árbol.
        else if(value < this.getRoot()) {
            // Nos movemos a través del árbol hasta que el sig sea null o hasta que hallamos encontrado el valor buscado
            while(!actual.getValue().equals(value) && actual.getLeft() != null) {
                actual = actual.getLeft();
            }
            // Retornamos si el valor del nodo sobre el que estamos parados es igual al valor buscado.
            return actual.getValue().equals(value);
        }
        // Caso en el que el valor buscado y el valor del nodo sobre el que estamos son iguales.
        else {
            return true;
        }
    }
     */

    // Recorre el árbol para hacer los distintos tipos de impresiones.
    private void printTraverse(TreeNode node, String recorrido) {
        // Si el nodo es null imprime un - para visualizar mejor la estructura del árbol y corta.
        if(node == null) {
            System.out.print("-");
            return;
        }

        if(recorrido.equals("preorder")) {
            System.out.print(node.getValue());
        }

        // Llamada recursiva para imprimir todo el lado izq del árbol.
        printTraverse(node.getLeft(), recorrido);   // Recorre el lado izquierdo

        if(recorrido.equals("order")) {
            System.out.print(node.getValue());
        }

        // Al alcanzar un nodo nulo, la recursión retrocede, desempilando las llamadas.
        // Se continúa explorando el subárbol derecho.
        printTraverse(node.getRight(), recorrido);  // Luego el lado derecho

        if(recorrido.equals("posorder")) {
            System.out.print(node.getValue());
        }
    }

    public void printPreOrden() {
        printTraverse(this.root, "preorder");
    }

    public void printInOrder() {
        printTraverse(this.root, "order");
    }

    public void printPosOrder() {
        printTraverse(this.root, "posorder");
    }

    private List<Integer> levelTraverse(TreeNode node, int count, int targetLevel) {
        // Si el nodo es null retorna una lista vacía.
        if(node == null) {
            return new ArrayList<>();
        }

        // Cuando el contador es igual al nivel deseado crea una lista con el valor del nodo y de los nodos
        // a su derecha e izquierda.
        if(count == targetLevel) {
            List<Integer> result = new ArrayList<>();
            result.add(node.getValue());
            return result;
        }

        // Recorre el lado izq del árbol subiendo de nivel.
        List<Integer> leftValues = levelTraverse(node.getLeft(),count+1, targetLevel);

        // Recorre el lado izq del árbol subiendo de nivel.
        List<Integer> rightValues = levelTraverse(node.getRight(), count+1, targetLevel);

        // Unifica todos los valores hallados en el nivel deseado en una estructura.
        leftValues.addAll(rightValues);

        return leftValues;
    }

    public List<Integer> getElemAtLevel(int targetLevel) {
        if(this.isEmpty()) {
            return new ArrayList<>();
        }
        return levelTraverse(this.root, 0, targetLevel);
    }

    private List<Integer> leavesTraverse(TreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }
        if(node.getLeft() == null && node.getRight() == null) {
            List<Integer> result = new ArrayList<>();
            result.add(node.getValue());
            return result;
        }
        List<Integer> leavesLeft = leavesTraverse(node.getLeft());
        List<Integer> leavesRight = leavesTraverse(node.getRight());

        leavesLeft.addAll(leavesRight);

        return leavesLeft;
    }

    public List<Integer> getFrontera() {
        if(this.isEmpty()) {
            return new ArrayList<>();
        }
        return leavesTraverse(this.root);
    }
}
