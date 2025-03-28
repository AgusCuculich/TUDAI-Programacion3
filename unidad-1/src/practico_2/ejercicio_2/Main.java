package practico_2.ejercicio_2;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(buscar(arr, 7, 0, arr.length-1));

        int[] arr2 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(buscar(arr2, 6, 0, arr2.length-1));

        int[] arr3 = {1};
        System.out.println(buscar(arr3, 5, 0, arr3.length-1));
    }

    // Búsqueda binaria
    public static int buscar(int[] arr, int valor, int ini, int fin) {
        // Si ini > fin se recorrieron las posiciones y no se encontró el valor buscado
        if(ini > fin) {
            return -1;
        } else {
            int medio = (ini + fin) / 2;
            if(valor > arr[medio]) {
                // Buscamos el valor entre la pos siguiente a mid y la última posición.
                return buscar(arr, valor, medio+1, fin);
            } else if (valor < arr[medio]) {
                // Buscamos el valor entre la pos anterior a mid y la primera posición.
                return buscar(arr, valor, ini, medio-1);
            } else {
                // Al retornar medio, retornamos un int <> de -1, lo que indica que el número fue hallado.
                return medio;
            }
        }
    }
}
