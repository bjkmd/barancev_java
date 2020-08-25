package ua.bjk.java.sandbox;

public class HelloWorldFromIdea {
    public static void main(String[] args) {
        System.out.println("Hello from Idea!!!");
        Square square = new Square(5);

        System.out.println("Площадь квадрата со стороной "+square.side+" равна "+square.area());

        Point p1 = new Point(0,0);
        Point p2 = new Point(10,10);

        System.out.println(Point.distance(p1,p2));

         p1 = new Point(0,0);
         p2 = new Point(0,0);

        System.out.println(Point.distance(p1,p2));
    }

}
