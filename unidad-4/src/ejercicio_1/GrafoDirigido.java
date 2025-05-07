package ejercicio_1;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> arcosAdyacentes;
    private HashMap<Integer,Character> estadoVertices;
    private int cantArcos;

    public GrafoDirigido() {
        this.arcosAdyacentes = new HashMap<>();
        this.estadoVertices = new HashMap<>();
        this.cantArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        // Primero nos aseguramos de no insertar un vértice que ya exista en el grafo. Si no existe, añadimos el vértice
        // con una lista vacía de arcos.
        if(!this.arcosAdyacentes.containsKey(verticeId)) {
            this.arcosAdyacentes.put(verticeId, new ArrayList<>());
            this.estadoVertices.put(verticeId, 'B');
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        // Nos aseguramos que el vértice que queremos eliminar realmente exista en el grafo
        if(!contieneVertice(verticeId)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId);
        }
        // Iterator<Arco<T>> it = obtenerArcos();
        // La línea de código anterior no sirve para el objetivo de este método ya que, NO elimina nada del grafo real
        //  porque estás eliminando de totalArcos, una lista temporal, no del HashMap original.
        for(ArrayList<Arco<T>> arcos : arcosAdyacentes.values()) {
            // Obtenemos cada lista de arcos e iteramos por cada una para eliminar aquellos arcos que tengan como
            // destino aquel que queremos eliminar.
            Iterator<Arco<T>> it = arcos.iterator();
            while(it.hasNext()) {
                Arco<T> arco = it.next();
                if(arco.getVerticeDestino() == verticeId) {
                    it.remove();
                    break;
                }
            }
        }
        // Almacenamos todos los arcos que salgan del vértice que queremos eliminar, para así obtener cuántos y restar
        // esa cantidad de nuestro atributo contador de arcos.
        ArrayList<Arco<T>> arcosSalientes = this.arcosAdyacentes.get(verticeId);
        this.cantArcos -= arcosSalientes.size();
        // Eliminamos definitivamente el vértice del grafo (y junto a él, su lista de arcos salientes).
        this.arcosAdyacentes.remove(verticeId);
        this.estadoVertices.remove(verticeId)
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        // Nos aseguramos de que existan ambos vértices para que también pueda existir el arco.
        if (!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId1 + " o " + verticeId2);
        }
        // Obtenemos la lista de arcos del vértice origen.
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId1);
        // Creamos el nuevo arco que queremos insertar.
        Arco<T> nuevoArco = new Arco<>(verticeId1, verticeId2, etiqueta);
        // Controlamos que el arco nuevo no exista en el grafo, lo insertamos de no ser así, y aumentamos el contador
        // de arcos.
        if(!arcos.contains(nuevoArco)) {
            arcos.add(nuevoArco);
            this.cantArcos++;
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // Nos aseguramos de que existan ambos vértices para que también pueda existir el arco.
        if(!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId1 + " o " + verticeId2);
        }
        // Obtenemos la lista de arcos del vértice origen y creamos un iterador de la misma.
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId1);
        Iterator<Arco<T>> it = arcos.iterator();
        while(it.hasNext()) {
            Arco<T> arco = it.next();
            // Verificamos que alguno de los arcos tengo como destino el vérticeId2. Si es así, eliminamos el arco y
            // restamos el mismo del contador de arcos. También cortamos la función (ya que no deberían haber arcos
            // repetidos.
            if(arco.getVerticeDestino() == verticeId2) {
                it.remove();
                cantArcos--;
                break;  // rompemos porque sólo hay un arco de v1 a v2
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.arcosAdyacentes.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // Nos aseguramos de que existan ambos vértices para que también pueda existir el arco.
        if(!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId1 + " o " + verticeId2);
        }
        // Obtenemos la lista de todos los arcos del vértice origen.
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId1);
        for(Arco<T> arcoActual : arcos) {
            // Por cada arco, verificamos si el vértice destino es el mismo a verticeId2.
            if(arcoActual.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        // Nos aseguramos de que existan ambos vértices para que también pueda existir el arco.
        if(!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId1 + " o " + verticeId2);
        }
        // Nos traemos la lista de arcos del vertice de origen
        ArrayList<Arco<T>> adyacentes = this.arcosAdyacentes.get(verticeId1);
        // Buscamos aquel que tenga como destino el vértice de interés (verticeId2) y, de ser hallado, lo devolvemos.
        for(Arco<T> arco : adyacentes) {
            if(arco.getVerticeDestino() == verticeId2) {
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        // Devuelve la cantidad de claves que hay en el mapa (tamaño del mismo)
        return this.arcosAdyacentes.size();
    }

    @Override
    public int cantidadArcos() {
        return this.cantArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.arcosAdyacentes.keySet().iterator();
        // En caso de que KeySet devuelva un Set vacío, el iterador que devuelva esta función seguirá siendo un iterador
        // válido que no tiene elementos
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // Verificamos que el vértice exista en el grafo
        if(!contieneVertice(verticeId)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId);
        }
        // Creamos una lista para guardar los vertices adyacentes, y obtenemos la lista de arcos del verticeId.
        ArrayList<Integer> adyacentes = new ArrayList<>();
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId);
        // Por cada arco añadimos a la lista de adyacentes el vértice destino.
        for(Arco<T> arco : arcos) {
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        // Creamos una lista vacía para almacenar una copia de los arcos del grafo
        ArrayList<Arco<T>> totalArcos = new ArrayList<>();
        for(ArrayList<Arco<T>> arcos : this.arcosAdyacentes.values()) {
            // iteramos cada lista de arcos y los añadimos al arreglo creado
            totalArcos.addAll(arcos);
        }
        return totalArcos.iterator();
        // Si la lista existe (no es null), no necesitas comprobar si está vacía antes de llamar a iterator()
        // El iterador de una lista vacía simplemente te dice que no hay elementos (hasNext() → false).
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // Verificamos que el vértice exista en el grafo
        if(!contieneVertice(verticeId)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId);
        }
        // Obtenemos la lista de arcos de nuestro vértice de interés.
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId);
        // Si por algún motivo "arcos" fuera null, devolvemos un iterador vacío. Caso contrario, devolvemos el iterador
        // de la lista.
        return arcos != null ? arcos.iterator() : Collections.emptyIterator();
        // Collections.emptyIterator() te da un iterador que no tiene elementos.
        // De esta manera no devolvemos un null que genere un error ante el sig caso:
        // Iterator<Arco<T>> it = grafo.obtenerArcos(id);
        //    while (it.hasNext()) {
        //        Arco<T> arco = it.next();
        //        …
        //    }
    }

    public void DFS(){
        //Al modificar las entries, se modifican tambien los valores del hashmap original
        // (el set tiene las mismas referencias que el mapa)
        Set<Map.Entry<Integer, Character>> entries = this.estadoVertices.entrySet();

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
        Iterator<Integer> itVerticesAd = this.obtenerAdyacentes(verticeId);
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

    public void BFS() {
        // Creamos una fila vacía
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Map.Entry<Integer, Character>> entries = this.estadoVertices.entrySet();

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
            Iterator<Integer> adyacentes = obtenerAdyacentes(first);
            while(adyacentes.hasNext()) {
                int currentAd = adyacentes.next();
                if(this.estadoVertices.get(currentAd).equals('B')) {
                    this.estadoVertices.put(currentAd, 'N');
                    queue.add(currentAd);
                }
            }
        }
    }
}
