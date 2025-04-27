````java
import practico_2.ejercicio_1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public List<String> palabrasConNVocales(int n) {
    List<String> lista = new ArrayList<>();
    if (this.isEmpty()) {
        return lista;
    }
    palabrasConNVocales(this.root, n, lista, "");
    return lista;
}

private void palabrasConNVocales(TreeNode node, int n, ArrayList<String> lista, String palabra) {
    if(node == null) {
        return;
    }
    if(node.getValue().esVocal()) {
        n--;
    }
    palabra+= node.getValue();
    if(node.getLeft() == null && node.getRight() == null) {
        if(n == 0) {
            lista.add(palabra);
        }
    }
    palabrasConNVocales(node.getLeft(), n, lista, palabra);
    palabrasConNVocales(node.getRight(), n, lista, palabra);
}
````