package practico_2.ejercicio_1;

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

    public Integer getRoot() {
        // Devuelve el valor almacenado en el nodo raíz o null si el nodo no existe.
        return this.root != null ? this.root.getValue() : null;
    }

    public boolean isEmpty() {
        // Informa si el árbol está vacío o no.
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
}
