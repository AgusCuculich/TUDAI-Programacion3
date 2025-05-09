package ejercicio_1.estados_vertices;

import ejercicio_1.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class MapaDeEstadosDeRecorrido<T> {
    protected HashMap<Integer,Character> estadoVertices;
    protected Grafo<T> grafo;

    public MapaDeEstadosDeRecorrido(Grafo<T> grafo) {
        this.estadoVertices = new HashMap<>();
        this.grafo = grafo;
        cargarEstructura();
    }

    public void cargarEstructura() {
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while(vertices.hasNext()) {
            Integer verticeId = vertices.next();
            this.estadoVertices.put(verticeId, 'B');
        }
    }
}
