package ejercicio_1.estados_vertices;

import ejercicio_1.Grafo;

import java.util.*;

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

    public void limpiarEstructura() {
        Set<Map.Entry<Integer, Character>> entries = this.estadoVertices.entrySet();

        // Para cada vértice del mapa de estados, los pintamos de blanco
        for(Map.Entry<Integer, Character> entry : entries) {
            entry.setValue('B');
        }
    }

    // Ejercicio 4
    public ArrayList<Integer> obtenerCaminoDeMayorLongitud(Integer start, Integer target) {
        ArrayList<Integer> recorridoMayor = new ArrayList<>();
        ArrayList<Integer> recorridoActual = new ArrayList<>();
        limpiarEstructura();
        obtenerCaminoDeMayorLongitud(start, target, recorridoActual, recorridoMayor);
        return recorridoMayor;
    }

    private void obtenerCaminoDeMayorLongitud(Integer current, Integer target, ArrayList<Integer> recorridoActual,
                                              ArrayList<Integer> recorridoMayor) {
        recorridoActual.add(current);
        this.estadoVertices.put(current, 'A');
        if (current.equals(target)) {
            if (recorridoActual.size() > recorridoMayor.size()) {
                recorridoMayor.clear();
                recorridoMayor.addAll(recorridoActual);
            }
        } else {
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(current);
            while(adyacentes.hasNext()) {
                Integer sig = adyacentes.next();
                if(this.estadoVertices.get(sig).equals('B')) {
                    obtenerCaminoDeMayorLongitud(sig, target, recorridoActual, recorridoMayor);
                }
            }
        }
        recorridoActual.removeLast();   // Backtracking

        //Como este vertice podria ser accesible desde otro camino, lo pongo de nuevo como no visitado
        this.estadoVertices.put(current, 'B');
    }

    // Ejercicios 5
    public ArrayList<Integer> verticesQueLlegan(Integer target) {
        ArrayList<Integer> puntosDePartida = new ArrayList<>();
        Iterator<Integer> itVertices = this.grafo.obtenerVertices();
        while(itVertices.hasNext()) {
            Integer current = itVertices.next();
            this.limpiarEstructura();
            if(existeCamino(current, target)) {
                puntosDePartida.add(current);
            }
        }
        return puntosDePartida;
    }

    private boolean existeCamino(Integer current, Integer target) {
        if(current.equals(target)) {
            return true;
        }

        this.estadoVertices.put(current, 'A');

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(current);
        while(adyacentes.hasNext()) {
            Integer sig = adyacentes.next();
            if(!this.estadoVertices.get(sig).equals('A')) {
                if(existeCamino(sig, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Ejercicio 6
    public ArrayList<Integer> obtenerCaminoMasCorto(Integer esquinaA, Integer esquinaB) {
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> predecesores = new HashMap<>();
        ArrayList<Integer> camino = new ArrayList<>();

        limpiarEstructura();
        // Marcamos el vertice como ya recorrido
        this.estadoVertices.put(esquinaA, 'N');
        // Añadimos el origen a la fila
        queue.add(esquinaA);
        // Añadimos el origen al arreglo de predecesores, sin este poseer un predecesor
        predecesores.put(esquinaA, null); // origen no tiene predecesor

        while(!queue.isEmpty()) {
            // Guardamos el primer elemento de la fila y lo eliminamos de la misma
            Integer first = queue.poll();
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(first);

            while(adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if(this.estadoVertices.get(adyacente).equals('B')) {
                    // Establecemos el ady como ya recorrido y lo añadimos a la fila.
                    this.estadoVertices.put(adyacente, 'N');
                    // Añadimos el adyacente(key) con su predecesor(value) al hashmap
                    predecesores.put(adyacente, first);
                    // Si encontramos el destino, cortamos BFS
                    if (adyacente.equals(esquinaB)) {
                        queue.clear(); // para cortar BFS
                        break;
                    }
                    // Agrega el ady a la fila para seguir recorriendo
                    queue.add(adyacente);
                }
            }
        }

        // Reconstruir camino desde esquinaB hacia atrás.
        // Verifica que esquinaB este dentro del hashmap de predecesores (la esquina existe en el grafo)
        // Verifica que la esquina A y B sean distintas (así se devuelve la misma esquina en caso de ser iguales)
        if (!predecesores.containsKey(esquinaB) && !esquinaA.equals(esquinaB)) {
            return camino; // No hay camino
        }

        // El primer paso para reconstruir el camino, es partir de esquinaB.
        Integer paso = esquinaB;
        // Cuando sea igual a null es porque llegamos al origen (esquinaA) -> no hay predecesores
        while (paso != null) {
            // Al agregar al principio, logramos que el camino quede en el orden correcto
            // (ya que vamos de adelante hacia atrás)
            camino.addFirst(paso);
            // Buscamos cuál fue el nodo anterior desde el cual llegamos a paso durante el BFS.
            paso = predecesores.get(paso);
        }

        return camino;
    }
}
