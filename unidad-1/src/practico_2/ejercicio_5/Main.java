package practico_2.ejercicio_5;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4};
        System.out.println('\n' + "La igualdad fue hallada? " + determinarIgualdad(arr, 0));
    }

    public static boolean determinarIgualdad(int[] arr, int pos) {
        // Verificamos que la posición sea válida.
        if(pos >= 0 && pos < arr.length) {
            System.out.print(arr[pos]);
            if(arr[pos] == pos) {
                // Si se encuentra un elemento igual a su posición, la función se corta devolviendo true y se
                // completan el resto de funciones pausadas en la pila.
                return true;
            }
            // Si no se encuentra la igualdad, la recursión continua.
            return determinarIgualdad(arr, pos+1);
        }
        // Devolvemos false en caso de recorrer todo el arreglo y no hallar una igualdad. Lo mismo sucede si
        // la posición es inválida.
        return false;
    }
}
