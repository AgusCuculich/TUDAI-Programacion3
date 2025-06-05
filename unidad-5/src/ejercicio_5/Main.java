package ejercicio_5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public static ArrayList<Procesador> asignarTareas(ArrayList<Procesador> procesadores, ArrayList<Integer> tareas) {
        ArrayList<Procesador> mejorSolucion = new ArrayList<>();
        backtracking(0, procesadores, tareas, mejorSolucion);
        return mejorSolucion;
    }

    public static void backtracking(int indice, ArrayList<Procesador> procesadores, ArrayList<Integer> tareas, ArrayList<Procesador> mejorSolucion) {
        if(indice >= tareas.size()) {
            if(mejorSolucion.isEmpty() || obtenerMayorConsumo(procesadores) < obtenerMayorConsumo(mejorSolucion)) {
                mejorSolucion.clear();
                mejorSolucion = new ArrayList<>(procesadores);
            }
        }
        for(Procesador p : procesadores) {
            p.addTarea(tareas.get(indice));
            backtracking(indice+1, procesadores, tareas, mejorSolucion);
            p.eliminarTarea(tareas.get(indice));
        }
    }

    public static Integer obtenerMayorConsumo(ArrayList<Procesador> procesadores) {
        Integer mayorConsumo = Integer.MIN_VALUE;
        for(Procesador p : procesadores) {
            Integer consumoProcActual = p.getConsumoTotal();
            if(consumoProcActual > mayorConsumo) {
                mayorConsumo = consumoProcActual;
            }
        }
        return mayorConsumo;
    }
}
