package ejercicio_1.estados_vertices;

import ejercicio_1.Grafo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class RecorridoBFS<T> extends MapaDeEstadosDeRecorrido<T> {

    public RecorridoBFS(Grafo<T> grafo) {
        super(grafo);
    }

    public void BFS() {
        // Creamos una fila vacía
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Map.Entry<Integer, Character>> entries = super.estadoVertices.entrySet();

        // Para cada vértice del mapa de estados, los pintamos de blanco
        for(Map.Entry<Integer, Character> entry : entries) {
            entry.setValue('B');
        }

        for(Map.Entry<Integer, Character> entry : entries) {
            if(entry.getValue().equals('B')) {
                BFS_Visit(entry.getKey(), queue);
            }
        }
    }

    private void BFS_Visit(Integer verticeId, LinkedList<Integer> queue) {
        this.estadoVertices.put(verticeId, 'N');
        queue.add(verticeId);
        while(!queue.isEmpty()) {
            int first = queue.poll(); // Elimina y devuelve el primero (o null si vacío).
            Iterator<Integer> adyacentes = super.grafo.obtenerAdyacentes(first);
            while(adyacentes.hasNext()) {
                int currentAd = adyacentes.next();
                if(super.estadoVertices.get(currentAd).equals('B')) {
                    super.estadoVertices.put(currentAd, 'N');
                    queue.add(currentAd);
                }
            }
        }
    }
}
