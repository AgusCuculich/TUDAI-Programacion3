package ejercicio_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 15, 10));
        c.sort((a,b) -> b-a);
        ArrayList<Integer> solucion = greedy(c, 26);
        if(solucion != null) {
            for(Integer num : solucion) {
                System.out.println(num);
            }
        } else {
            System.out.println("No se pudo");
        }
    }

    public static boolean solucion(ArrayList<Integer> s, int m) {
        int total = calcularTotal(s);
        return total == m;
    }

    public static Integer seleccionar(ArrayList<Integer> c) {
        return c.getFirst();
    }


    public static int calcularTotal(ArrayList<Integer> arr) {
        int suma = 0;
        for(Integer num : arr) {
            suma+= num;
        }
        return suma;
    }

    public static boolean factible(ArrayList<Integer> s, Integer candidato, int m) {
        int total = calcularTotal(s) + candidato;
        return total <= m;
    }

    public static ArrayList<Integer> greedy(ArrayList<Integer> c, int m) {
        ArrayList<Integer> s = new ArrayList<>();
        while(!c.isEmpty() && !solucion(s, m)) {
            Integer candidato = seleccionar(c);
            if(factible(s, candidato, m)) {
                s.add(candidato);
            } else {
                c.remove(candidato);
            }
        }
        if(solucion(s, m)) {
            return s;
        }
        return null;
    }
}
