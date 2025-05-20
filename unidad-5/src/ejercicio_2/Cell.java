package ejercicio_2;

public class Cell {
    private int value;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;

    public Cell(int value, boolean right, boolean left, boolean up, boolean down) {
        this.value = value;
        this.right = right;
        this.left = left;
        this.up = up;
        this.down = down;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
