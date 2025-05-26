package ejercicio_4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> conjuntoOriginal = new ArrayList<>(Arrays.asList(1, 5, 11, 5));
        dividirConjunto(conjuntoOriginal);
    }

    public static Integer calcularTotal(ArrayList<Integer> conjuntoOriginal) {
        Integer suma = 0;
        for(Integer elemento : conjuntoOriginal) {
            suma+= elemento;
        }
        return suma;
    }

    public static void dividirConjunto(ArrayList<Integer> conjuntoOriginal) {
        ArrayList<Integer> conjuntoA = new ArrayList<>();
        ArrayList<Integer> conjuntoB = new ArrayList<>();
        if(calcularTotal(conjuntoOriginal) % 2 == 0) {
            backtrack(0, calcularTotal(conjuntoOriginal)/2 , conjuntoA, conjuntoOriginal);
        } else {
            System.out.println("La suma del conjunto original es un numero impar");
            return;
        }
        for(Integer e : conjuntoOriginal) {
            if(!conjuntoA.contains(e)) {
                conjuntoB.add(e);
            }
        }
        System.out.print("{");
        for(Integer e : conjuntoA) {
            System.out.print(e);
        }
        System.out.print("}");
        System.out.println();
        System.out.print("{");
        for(Integer e : conjuntoB) {
            System.out.print(e);
        }
        System.out.print("}");
    }

    public static boolean backtrack(int indice, int target, ArrayList<Integer> conjuntoA, ArrayList<Integer> conjuntoOriginal) {
        if(calcularTotal(conjuntoA).equals(target)) {
            return true;
        }
        if(calcularTotal(conjuntoA) > target || indice >= conjuntoOriginal.size()) {
            return false;
        }

        // Exploramos la rama donde el elemento sí es incluido.
        conjuntoA.add(conjuntoOriginal.get(indice));
        if (backtrack(indice + 1, target, conjuntoA, conjuntoOriginal)) {
            return true;  // Ya se encontró solución → no seguir
        }
        // Se deshace la inclusión del elemento actual → backtrack.
        conjuntoA.removeLast();

        // Al haber quitado el último elemento, se explora la rama donde el mismo no fue incluido.
        if (backtrack(indice + 1, target, conjuntoA, conjuntoOriginal)) {
            return true;  // Ya se encontró solución → no seguir
        }

        return false;  // Ninguna rama encontró solución
    }
}
