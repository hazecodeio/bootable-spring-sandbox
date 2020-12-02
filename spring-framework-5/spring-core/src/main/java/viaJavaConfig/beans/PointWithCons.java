package viaJavaConfig.beans;

public class PointWithCons {
    private int x;
    private int y;

    public PointWithCons(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointWithCons(Coordinates coordinates) {
        x = coordinates.getX();
        y = coordinates.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointWithCons{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
