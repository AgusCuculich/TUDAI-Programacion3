package ejercicio_1.estados_vertices;

import ejercicio_1.Grafo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RecorridoDFS<T> extends MapaDeEstadosDeRecorrido<T> {

    public RecorridoDFS(Grafo<T> grafo) {
        super(grafo);
    }

    public void DFS(){
        //Al modificar las entries, se modifican tambien los valores del hashmap original
        // (el set tiene las mismas referencias que el mapa)
        Set<Map.Entry<Integer, Character>> entries = super.estadoVertices.entrySet();

        //Para cada vértice del mapa de estados, los pintamos de blanco
        for(Map.Entry<Integer,Character> entry : entries){
            entry.setValue('B');
        }

        for(Map.Entry<Integer,Character> entry : entries){
            //Si el vértice esta sin visitar (blanco)
            if (entry.getValue().equals('B')){
                DFS_Visit(entry.getKey());
            }
        }
    }

    private void DFS_Visit(Integer verticeId){
        //Marcamos el vértice como visitado (amarillo)
        this.estadoVertices.put(verticeId,'A');
        // Creamos un iterador de todos los vertices adyacentes del que estamos posicionados
        Iterator<Integer> itVerticesAd = super.grafo.obtenerAdyacentes(verticeId);
        while(itVerticesAd.hasNext()) {
            // Guardamos el vértice y pasamos al sig
            Integer verticeAd = itVerticesAd.next();
            // Si este vértice adyacente esta blanco, recorremos sus adyacentes
            if(this.estadoVertices.get(verticeAd).equals('B')) {
                DFS_Visit(verticeAd);
            }
        }
        // Una vez que recorrimos todos los adyecentes de este vértice, lo pintamos de negro
        this.estadoVertices.put(verticeId, 'N');
    }
}
