package practico_2.ejercicio_1;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 6, 2};
        System.out.println(ordenadoDesc(arr1, 0));
    }

    // Evalua el caso de que el arr este ordenado ascendentemente
    public static boolean ordenadoAsc(int[] arr, int pos) {
        // Verificamos que hayan ingresado una posición válida
        if (pos < 0 || pos >= arr.length) {
            return false;
        }
        if(pos < arr.length-1) {
            if(arr[pos] > arr[pos+1]) {
                // Si el elemento actual es mayor que el siguiente, el arreglo no está ordenado de forma ascendente.
                return false;
            }
            // Llamamos recursivamente a la función con la siguiente posición para verificar el resto del arreglo.
            return ordenadoAsc(arr, pos + 1);
        }
        return true;
    }

    // Evalua el caso de que el arr este ordenado descendentemente
    public static boolean ordenadoDesc(int[] arr, int pos) {
        // Verificamos que hayan ingresado una posición válida
        if (pos < 0 || pos >= arr.length) {
            return false;
        }
        if(pos < arr.length-1) {
            // Si el elemento actual es menor que el siguiente, el arreglo no está ordenado de forma descendiente.
            if(arr[pos] < arr[pos+1]) {
                return false;
            }
            // Llamamos recursivamente a la función con la siguiente posición para verificar el resto del arreglo.
            return ordenadoDesc(arr, pos + 1);
        }
        return true;
    }

    /*
    * 1.1
    * La complejidad es de O(n) ya que en el peor de los casos habrá que acceder a todos los elementos del array.
    * Acceder dos veces a arr[pos] y arr[pos+1] no lo convierte en O(n²), ya que sigue siendo una cantidad constante de
    * accesos en cada iteración.
    *
    * 1.2
    * No habría problema en resolver el ejercicio con recursión pero existen opciones menos complejas y más eficientes
    * en cuanto al consumo de recursos.
    *
    * 1.3
    * Si fuera una lista vinculada habría que refactorizar el código para hacer uso de la misma junto con un iterador
    * para recorrerla. El acceso a los elementos sería secuencial ya que cada vez que llamamos a it.next(), se accede
    * a un único nodo en la lista en tiempo O(1). En conclusión, la complejidad será, como en el caso del arreglo, de
    * O(n).
    * */


}
