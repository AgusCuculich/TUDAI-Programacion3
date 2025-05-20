package ejercicio_2;

public class Main {
    public static void main(String[] args) {
        Board laberinto = new Board(3);

        /*
        // Ejemplo A
        laberinto.setCell(0,0, new Cell(1, true, false, false, true));
        laberinto.setCell(0, 1, new Cell(2, true, true, false, true));
        laberinto.setCell(0, 2, new Cell(3, false, true, false, true));

        laberinto.setCell(1, 0, new Cell(4, true, false, true, true));
        laberinto.setCell(1, 1, new Cell(5, true, true, true, true));
        laberinto.setCell(1, 2, new Cell(6, false, true, true, true));

        laberinto.setCell(2, 0, new Cell(7, true, false, true, false));
        laberinto.setCell(2, 1, new Cell(8, true, true, true, false));
        laberinto.setCell(2, 2, new Cell(9, false, true, true, false));
         */


        // Ejemplo B
        laberinto.setCell(0,0, new Cell(2, true, false, false, true));
        laberinto.setCell(0, 1, new Cell(3, true, true, false, true));
        laberinto.setCell(0, 2, new Cell(7, false, true, false, true));

        laberinto.setCell(1, 0, new Cell(5, true, false, true, true));
        laberinto.setCell(1, 1, new Cell(8, true, true, true, true));
        laberinto.setCell(1, 2, new Cell(1, false, true, true, true));

        laberinto.setCell(2, 0, new Cell(4, true, false, true, false));
        laberinto.setCell(2, 1, new Cell(6, true, true, true, false));
        laberinto.setCell(2, 2, new Cell(9, false, true, true, false));

        laberinto.hallarCaminoMasCorto(9);
    }
}
