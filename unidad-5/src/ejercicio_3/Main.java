package ejercicio_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> conjunto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        hallarCombinaciones(9, conjunto);
    }

    public static ArrayList<ArrayList<Integer>> hallarCombinaciones(int M, ArrayList<Integer> conjunto) {
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        ArrayList<Integer> combinacion = new ArrayList<>();
        backtrack(0, M, 0, conjunto, combinacion, resultado);
        for(ArrayList<Integer> lista : resultado) {
            System.out.print("{");
            for(Integer e : lista) {
                System.out.print(e);
            }
            System.out.print("}");
        }
        return resultado;
    }
    public static void backtrack(int pos, int M, int suma, ArrayList<Integer> conjunto,
                                 ArrayList<Integer> combinacion, ArrayList<ArrayList<Integer>> resultado) {
        if (suma == M) {
            resultado.add(new ArrayList<>(combinacion));
            return;
        }

        if (suma > M || pos >= conjunto.size()) {
            return;
        }

        // Hay dos opciones por cada posición del conjunto:
        // 1. Incluir el número actual → avanza con pos + 1 y suma el valor.
        combinacion.add(conjunto.get(pos));
        // Se toma el número en la posición actual para ver que sucede al incluirlo.
        backtrack(pos + 1, M, suma + conjunto.get(pos), conjunto, combinacion, resultado);
        // Luego del llamado recursivo, se deshace la decisión y se vuelve al estado anterior.
        combinacion.removeLast(); // backtrack

        // No incluirlo → simplemente salta al siguiente (pos + 1) sin sumar nada.
        backtrack(pos + 1, M, suma, conjunto, combinacion, resultado);
        // Acá se ignora ese número y se prueba qué pasa al no incluirlo.
    }
}
