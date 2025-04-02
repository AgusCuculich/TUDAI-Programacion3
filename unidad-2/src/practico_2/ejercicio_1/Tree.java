package practico_2.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }


    // Ejercicio 1

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

    private List<Integer> getLeaves(TreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }
        if(node.getLeft() == null && node.getRight() == null) {
            List<Integer> result = new ArrayList<>();
            result.add(node.getValue());
            return result;
        }
        List<Integer> leavesLeft = getLeaves(node.getLeft());
        List<Integer> leavesRight = getLeaves(node.getRight());

        leavesLeft.addAll(leavesRight);

        return leavesLeft;
    }

    public List<Integer> getFrontera() {
        if(this.isEmpty()) {
            return new ArrayList<>();
        }
        return getLeaves(this.root);
    }

    private int heightOfTree(TreeNode node) {   // Complejidad -> O(n) ya que visita cada nodo una vez
        // La altura de un nodo se calcula de abajo hacia arriba, empezando en 0 para las hojas.
        // En cada paso, tomamos la mayor altura entre sus hijos y sumamos 1
        // para contar el arco que conecta el nodo actual con su hijo más profundo.
        if(node == null) {
            return -1;  // La áltura de un árbol con 1 elemento es 0, por lo tanto con 0 elementos es -1.
        }
        int leftDepth = heightOfTree(node.getLeft());   // Calcula altura del subárbol izquierdo
        int rightDepth = heightOfTree(node.getRight()); // Calcula altura del subárbol derecho

        return Math.max(leftDepth, rightDepth) + 1; // Devuelve la mayor altura + 1
    }

    public int getHeight() {
        if(this.isEmpty()) {
            return -1;
        }
        return heightOfTree(this.root);
    }

    private boolean deleteLeftChild(TreeNode node, Integer value) {
        // Si el valor del nodo izq del nodo en el que estamos parados es igual al valor buscado.
        if(node.getLeft() != null && node.getLeft().getValue().equals(value)) {

            // ----------------------------------------------------------- ELIMINAR HOJA
            // El izq del izq es null y el derecho del izq es null
            if(node.getLeft().getLeft() == null && node.getLeft().getRight() == null) {
                node.setLeft(null);
                return true;
            }
            //--------------------------------------------------------------------------


            // ------------------------------------------- ELIMINAR NODO CON UN SOLO HIJO
            // Explicado en el lado derecho
            if(node.getLeft().getLeft() == null || node.getLeft().getRight() == null) {
                if(node.getLeft().getLeft() != null) {
                    node.setLeft(node.getLeft().getLeft());
                } else if (node.getLeft().getRight() != null) {
                    node.setLeft(node.getLeft().getRight());
                }
                return true;
            }
            //--------------------------------------------------------------------------
        }
        return false;
    }

    private boolean deleteRightChild(TreeNode node, Integer value) {
        // Si el valor del nodo derecho del nodo en el que estamos parados es igual al valor buscado.
        if(node.getRight() != null && node.getRight().getValue().equals(value)) {

            // ----------------------------------------------------------- ELIMINAR HOJA
            // El izq del derecho es null y el derecho del derecho es null
            if(node.getRight().getLeft() == null && node.getRight().getRight() == null) {
                node.setRight(null);
                return true;
            }
            //--------------------------------------------------------------------------


            // ------------------------------------------- ELIMINAR NODO CON UN SOLO HIJO
            // Si un nodo tiene cero o un hijo, entonces podemos reemplazarlo con su único hijo.
            if(node.getRight().getLeft() == null || node.getRight().getRight() == null) {
                // Si el hijo izq del derecho NO es null, significa que el nodo a eliminar solo tiene un hijo izquierdo
                if(node.getRight().getLeft() != null) {
                    node.setRight(node.getRight().getLeft());   // Reemplazamos el nodo derecho con su hijo izquierdo.
                // Si el hijo derecho del derecho NO es null, significa que el nodo a eliminar solo tiene un hijo der.
                } else if(node.getRight().getRight() != null) {
                    node.setRight(node.getRight().getRight());  // Reemplazamos el nodo derecho con su hijo derecho.
                }
                return true;
            }
            //--------------------------------------------------------------------------
        }
        return false;
    }

    private boolean removeNodeWithTwoChildren(TreeNode node) {
        // ------------------------------------------------- ELIMINAR NODO CON DOS HIJOS
        if (node.getRight() != null) {
            // Utilizamos un aux para no perder el nodo a reemplazar y recorrer el árbol hasta encontra el NMI.
            // El padre sirve para eliminar aux una vez realizado el reemplazo.
            TreeNode aux = node.getRight();
            TreeNode parent = node; // Guardamos el padre de `aux`

            // Buscamos el Nodo Más Izquierdo del subárbol derecho
            while (aux.getLeft() != null) {
                parent = aux;  // Guardamos referencia al padre de `aux`
                aux = aux.getLeft();
            }

            node.setValue(aux.getValue());  // Remplazamos el valor del nodo a eliminar con el del NMI
            if (parent.getLeft() == aux) {  // Caso: viaje por la derecha y luego por la izq.
                parent.setLeft(null);
            } else {    // Caso: viaje por la derecha (no hay elementos a la izq de este -> es hoja)
                parent.setRight(aux.getRight());
            }
            return true;
        }
        return false;
        //--------------------------------------------------------------------------
    }

    private boolean delete(TreeNode node, Integer value) {
        if(node == null) {
            return false;
        }

        // Verifica si el hijo izquierdo contiene el valor buscado.
        if (value < node.getValue() && deleteLeftChild(node, value)) {
            return true;
        }

        // Verifica si el hijo derecho contiene el valor buscado.
        if (value > node.getValue() && deleteRightChild(node, value)) {
            return true;
        }

        // Verifica si el valor sobre el que esta parado es el buscado
        if (node.getValue().equals(value) && removeNodeWithTwoChildren(node)) {
            return true;
        }

        // 1. Se intenta eliminar el valor en el subárbol izquierdo (node.getLeft())
        // 2. Si delete(node.getLeft(), value) devuelve true, significa que el nodo fue encontrado y eliminado.
        // 3. En este caso, se retorna inmediatamente true y se detiene la ejecución, evitando buscar en el subárbol
        // derecho innecesariamente
        if (delete(node.getLeft(), value)) {
            return true;
        }
        return delete(node.getRight(), value);
    }

    public void delete(Integer value) {
        if(this.isEmpty()) {
            return;
        }
        if(this.root.getValue().equals(value) && this.root.getLeft() == null && this.root.getRight() == null) {
            this.root = null;
            return;
        }
        delete(this.root, value);
    }







    // Ejercicio 3

    private List<Integer> collectLeavesAbove(TreeNode node, int value) {
        if(node == null) {
            return new ArrayList<>();
        }
        if(node.getValue() > value && node.getLeft() == null && node.getRight() == null) {
            ArrayList<Integer> leaf = new ArrayList<>();
            leaf.add(node.getValue());
            return leaf;
        }

        List<Integer> leftLeaves = collectLeavesAbove(node.getLeft(), value);
        List<Integer> rightLeaves = collectLeavesAbove(node.getRight(), value);
        leftLeaves.addAll(rightLeaves);
        return leftLeaves;
    }

    // Devuelve una lista con los valores de las hojas mayores a x.
    public List<Integer> collectLeavesAbove(int value) {
        if(this.isEmpty()) {
            return new ArrayList<>();
        }
        if(value >= this.root.getValue()) {
            return collectLeavesAbove(this.root.getRight(), value);
        } else {
            return collectLeavesAbove(this.root, value);
        }
    }






    // Ejercicio 2

    private int sumInternalNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int sum = 0;
        if (node.getLeft() != null || node.getRight() != null) {
            sum += node.getValue();
        }
        sum += sumInternalNodes(node.getLeft());
        sum += sumInternalNodes(node.getRight());
        return sum;
    }

    // Retorna la suma de todos los nodos internos del árbol.
    public int sumInternalNodes() {
        if(this.isEmpty()) {
            return 0;
        }
        return sumInternalNodes(this.root);
    }


}
