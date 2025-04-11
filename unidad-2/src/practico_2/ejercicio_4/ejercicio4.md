Implementación en Tree

````java
private void completarArbol(TreeNode node) {
    if(node == null) {
        return;
    }
    completarArbol(node.getLeft());
    completarArbol(node.getRight());

    if(node.getValue() == null) {
        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        
        // Caso 1: ambos hijos tienen valores válidos
        if(left != null && right != null) {
            node.setValue(right.getValue() - left.getValue());
        }
        // Caso 2: solo uno de los hijos tiene un valor válido
        else if(left != null) {
            node.setValue(left.getValue());
        } else if (right != null) {
            node.setValue(right.getValue());
        }
    }
}

public void completarArbol() {
    if(this.isEmpty()) {
        return;
    }
    completarArbol(this.root);
}
````