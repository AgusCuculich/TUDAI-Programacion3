package practico_2.ejercicio_3;

public class Main {
    public static void main(String[] args) {
        calcularBinario(17);
    }

    public static void calcularBinario(int num) {
        if(num >= 0) {
            int cociente = num / 2;
            int resto = num % 2;
            // La conversión de decimal a binario usando divisiones sucesivas entre 2 termina cuando el cociente
            // llega a 0. Con lo que si el cociente no es 0, continuamos la recursión dividiendo el cociente entre 2.
            if(cociente != 0) {
                // Llamada recursiva con el cociente como parámetro para continuar la descomposición.
                calcularBinario(cociente);
            }
            // Imprimimos el resto (dígito binario) luego de la llamada recursiva. (Así se imprime del último dígito en
            // adelante y no queda el número al revés).
            System.out.print(resto);
        }
    }
}
