package ejercicio_5;

import java.util.ArrayList;

public class Procesador {
    ArrayList<Integer> tareas;

    public Procesador() {
        this.tareas = new ArrayList<>();
    }

    public void addTarea(Integer tarea) {
        this.tareas.add(tarea);
    }

    public Integer getConsumoTotal() {
        Integer total = 0;
        for (Integer tarea : this.tareas) {
            total+= tarea;
        }
        return total;
    }

    public void eliminarTarea(int indice) {
        this.tareas.remove(indice);
    }
}
