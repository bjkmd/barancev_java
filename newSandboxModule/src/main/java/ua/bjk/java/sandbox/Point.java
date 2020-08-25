package ua.bjk.java.sandbox;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point a,Point b){
        double catetOne = Math.abs(a.x-b.x);
        double catetTwo = Math.abs(a.y-b.y);

        return Math.sqrt(catetOne*catetOne+catetTwo*catetTwo);

    }
}
