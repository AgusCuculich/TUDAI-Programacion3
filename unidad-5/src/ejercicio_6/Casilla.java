package ejercicio_6;

public class Casilla {
    private char estado;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;

    public Casilla(char estado, boolean up, boolean left, boolean down, boolean right) {
        this.estado = estado;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }
}
