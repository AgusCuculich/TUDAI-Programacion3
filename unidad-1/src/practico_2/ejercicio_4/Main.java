package practico_2.ejercicio_4;

public class Main {
    public static void main(String[] args) {
        // Solo un elemento no es suficiente para la secuencia de Fibonacci. Mínimo 2
        secuenciaFibonacci(new int[6], 0);
    }

    public static void secuenciaFibonacci(int[] arr, int pos) {
        // Verificar que la posición para recorrer el arr no sea negativa y que hayan al menos dos elementos
        // antes de asignar valores
        if(pos >= 0 && arr.length >= 2) {
            if (pos == 0) { arr[0] = 0; } // El primer número de la secuencia Fibonacci es 0
            if (pos == 1) { arr[1] = 1; } // El segundo número de la secuencia Fibonacci es 1
            // Asegurarse de que no se acceda a posiciones fuera de los límites del array
            if(pos < arr.length) {
                if(pos >= 2) {
                    // Cálculo del número de Fibonacci en la posición pos
                    arr[pos] = arr[pos-2] + arr[pos-1];
                }
                System.out.print(arr[pos]);
                // Llamada recursiva para calcular el siguiente número
                secuenciaFibonacci(arr, pos+1);
            }
        }
    }
}
