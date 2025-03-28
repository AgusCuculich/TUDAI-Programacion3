package practico_2.ejercicio_5;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4};
        determinarIgualdad(arr, 0);
    }

    public static boolean determinarIgualdad(int[] arr, int pos) {
        if(pos>= 0) {
            if(pos < arr.length) {
                System.out.println(arr[pos]);
                determinarIgualdad(arr, pos+1);
                return arr[pos] == pos;
            }
        }
        return false;
    }

    /*
        public static boolean determinarIgualdad(int[] arr, int pos) {
        // Caso base: si hemos recorrido todo el array, retornamos true
        if (pos == arr.length) {
            return true;
        }

        // Imprimir el valor actual del arreglo y la posición
        System.out.println(arr[pos]);

        // Verificamos si el valor en arr[pos] es igual a la posición
        if (arr[pos] != pos) {
            return false;  // Si hay una diferencia, retornamos false
        }

        // Llamada recursiva: continuamos con el siguiente índice
        return determinarIgualdad(arr, pos + 1);
    }
     */
}
