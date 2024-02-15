import java.util.Arrays; 

public class One {
  public static void main(String[] args) {
    Shape[] circles = new Shape[3];
    circles[1] = new Circle();
    circles[0] = new Rectangle();
    circles[2] = new Triangle();
    for (Shape o : circles)
      if (o != null) {
        System.out.println( o.area() );
      } else {
        System.out.println( "N/A" );  
      }
  }
}

abstract class Shape {
  abstract public double area();
}

class Circle extends Shape {
  public double area() { return Math.PI; }
}

class Rectangle extends Shape {
  public double area() { return 1; }
}

class Triangle extends Shape {
  public double area() { return Math.sqrt( 2 ); }
}
