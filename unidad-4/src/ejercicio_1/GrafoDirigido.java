package ejercicio_1;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> arcosAdyacentes;
    private int cantArcos;

    public GrafoDirigido() {
        this.arcosAdyacentes = new HashMap<>();
        this.cantArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        if(!this.arcosAdyacentes.containsKey(verticeId)) {
            this.arcosAdyacentes.put(verticeId, new ArrayList<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        // TODO Auto-generated method stub
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            throw new IllegalArgumentException("Vertice no existente: " + verticeId1 + " o " + verticeId2);
        }
        ArrayList<Arco<T>> target = this.arcosAdyacentes.get(verticeId1);
        Arco<T> nuevoArco = new Arco<>(verticeId1, verticeId2, etiqueta);
        if(!target.contains(nuevoArco)) {
            target.add(nuevoArco);
            this.cantArcos++;
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.arcosAdyacentes.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if(!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            return false;
        }
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId1);
        for(Arco<T> arcoActual : arcos) {
            if(arcoActual.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            return null;
        }
        ArrayList<Arco<T>> adyacentes = this.arcosAdyacentes.get(verticeId1);
        for(Arco<T> arco : adyacentes) {
            if(arco.getVerticeDestino() == verticeId2) {
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
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
        if(!contieneVertice(verticeId)) {
            return Collections.emptyIterator();
        }
        ArrayList<Integer> adyacentes = new ArrayList<>();
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId);
        for(Arco<T> arco : arcos) {
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList totalArcos = new ArrayList<>();
        for(ArrayList<Arco<T>> arcos : this.arcosAdyacentes.values()) {
            totalArcos.addAll(arcos);
        }
        return totalArcos.iterator();
        // Si la lista existe (no es null), no necesitas comprobar si está vacía antes de llamar a iterator()
        // El iterador de una lista vacía simplemente te dice que no hay elementos (hasNext() → false).
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(!contieneVertice(verticeId)) {
            return Collections.emptyIterator();
        }
        ArrayList<Arco<T>> arcos = this.arcosAdyacentes.get(verticeId);
        return arcos.iterator();
        // Collections.emptyIterator() te da un iterador que no tiene elementos.
        // De esta manera no devolvemos un null que genere un error ante el sig caso:
        // Iterator<Arco<T>> it = grafo.obtenerArcos(id);
        //    while (it.hasNext()) {
        //        Arco<T> arco = it.next();
        //        …
        //    }
    }
}
