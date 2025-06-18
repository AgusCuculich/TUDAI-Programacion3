package ejercicio_6;

public class Main {
    public static void main(String[] args) {
        Jardin jardin = new Jardin(4);

        // m -> marron, v -> verde
        jardin.setCasilla(0,0, new Casilla('m',false, false, true, true));
        jardin.setCasilla(0,1, new Casilla('m',false, true, true, true));
        jardin.setCasilla(0,2, new Casilla('m',false, true, true, true));
        jardin.setCasilla(0,3, new Casilla('v',false, true, true, false));

        jardin.setCasilla(1,0, new Casilla('m',true, false, true, true));
        jardin.setCasilla(1,1, new Casilla('m',true, true, true, true));
        jardin.setCasilla(1,2, new Casilla('m',true, true, true, true));
        jardin.setCasilla(1,3, new Casilla('v',true, true, true, false));

        jardin.setCasilla(2,0, new Casilla('v',true, false, true, true));
        jardin.setCasilla(2,1, new Casilla('m',true, true, true, true));
        jardin.setCasilla(2,2, new Casilla('m',true, true, true, true));
        jardin.setCasilla(2,3, new Casilla('v',true, true, true, false));

        jardin.setCasilla(3,0, new Casilla('v',true, false, false, true));
        jardin.setCasilla(3,1, new Casilla('v',true, true, false, true));
        jardin.setCasilla(3,2, new Casilla('v',true, true, false, true));
        jardin.setCasilla(3,3, new Casilla('v',true, true, false, false));

        jardin.imprimirJardin();
        System.out.println("Pisadas: " + jardin.contarPisadas());
    }
}
