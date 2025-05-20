package ejercicio_2;

import java.util.ArrayList;

public class Board {
    private Cell[][] matrix;

    public Board(int size) {
        this.matrix = new Cell[size][size];
    }

    public void setCell(int fila, int col, Cell celda) {
        this.matrix[fila][col] = celda;
    }

    private int sumarValores(ArrayList<Cell> camino) {
        int suma = 0;
        for(Cell celda : camino) {
            suma += celda.getValue();
        }
        return suma;
    }

    public ArrayList<Cell> hallarCaminoMasCorto(int value) {
        ArrayList<Cell> caminoActual = new ArrayList<>();
        ArrayList<Cell> caminoMasCorto = new ArrayList<>();
        backtrack(0, 0, value, caminoActual, caminoMasCorto);
        for (Cell celda : caminoMasCorto) {
            System.out.print(celda.getValue());
        }
        return caminoMasCorto;
    }

    private void backtrack(int fila, int col, int value, ArrayList<Cell> caminoActual, ArrayList<Cell> caminoMasCorto) {
        caminoActual.add(this.matrix[fila][col]);

        /*for (Cell celda : caminoActual) {
            System.out.print(celda.getValue());
        }
        System.out.println();*/

        if(this.matrix[fila][col].getValue() == value) {
            if(caminoMasCorto.isEmpty() || sumarValores(caminoActual) < sumarValores(caminoMasCorto)) {
                caminoMasCorto.clear();
                caminoMasCorto.addAll(caminoActual);
            }
        }

        // Con esta verificación nos aseguramos que si se encontró el destino, no siga recorriendo para los lados del
        // mismo.
        if(this.matrix[fila][col].getValue() != value) {

            // Desplazamiento hacia la derecha
            if(this.matrix[fila][col].isRight()
                    && col + 1 < this.matrix[0].length
                    && !caminoActual.contains(this.matrix[fila][col+1])) {
                backtrack(fila, col +1, value, caminoActual, caminoMasCorto);
            }
            // Desplazamiento hacia la izquierda
            if(this.matrix[fila][col].isLeft()
                    && col - 1 >= 0
                    && !caminoActual.contains(this.matrix[fila][col-1])) {
                backtrack(fila, col - 1, value, caminoActual, caminoMasCorto);
            }
            // Desplazamiento hacia arriba
            if(this.matrix[fila][col].isUp()
                    && fila - 1 >= 0
                    && !caminoActual.contains(this.matrix[fila-1][col])) {
                backtrack(fila - 1, col, value, caminoActual, caminoMasCorto);
            }
            // Desplazamiento hacia abajo
            if(this.matrix[fila][col].isDown()
                    && fila + 1 < this.matrix.length
                    && !caminoActual.contains(this.matrix[fila+1][col])) {
                backtrack(fila + 1, col, value, caminoActual, caminoMasCorto);
            }

        }

        caminoActual.removeLast();  // Backtrack
    }
}
