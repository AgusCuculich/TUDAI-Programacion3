package ejercicio_6;

import java.util.ArrayList;

public class Jardin {
    private Casilla[][] matriz;
    private int filaInicio;
    private int colInicio;

    public Jardin(int size) {
        this.matriz = new Casilla[size][size];
    }

    public void setCasilla(int fila, int col, Casilla casilla) {
        this.matriz[fila][col] = casilla;
    }

    public void imprimirJardin() {
        System.out.println(this.matriz.length);
        for(int fila = 0; fila < this.matriz.length; fila++) {
            System.out.println();
            System.out.print("| ");
            for(int col = 0; col < this.matriz.length; col++) {
                System.out.print(this.matriz[fila][col].getEstado() + " [" + fila + "," + col + "]" + " | ");
            }
        }
    }

    public int contarPisadas() {
        int contador = 0;
        for(int fila = 0; fila < this.matriz.length; fila++) {
            for(int col = 0; col < this.matriz.length; col++) {
                if(this.matriz[fila][col].getEstado() == 'm') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void establecerInicio(int fila, int col) {
        this.filaInicio = fila;
        this.colInicio = col;
    }

    public ArrayList<Casilla> mostrarRecorrido() {
        ArrayList<Casilla> recorridoActual = new ArrayList<>();
        ArrayList<Casilla> recorridoCaballo = new ArrayList<>();
        int pisadasTotales = this.contarPisadas();
        //backtrack();
        return recorridoCaballo;
    }

    public void backtrack(int fila, int col, int pisadasTotales, int contador, ArrayList<Casilla> recorridoActual, ArrayList<Casilla> recorridoCaballo) {
        if(fila == this.filaInicio && col == this.colInicio && pisadasTotales == contador) {
            recorridoCaballo.addAll(recorridoActual);
        }

        if(this.matriz[fila][col].isUp()
                && fila - 1 >= 0
                && !recorridoActual.contains(this.matriz[fila - 1][col])
                && this.matriz[fila][col].getEstado() == 'm') {
            backtrack(fila - 1, col, pisadasTotales, contador, recorridoActual, recorridoCaballo);
        }
    }
}
