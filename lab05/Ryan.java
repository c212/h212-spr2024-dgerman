// compile then run java Two 12 
// instead of 12 put any number of circles you desire on the command line 

import javax.swing.*; 
import java.awt.*;
import java.util.*;
import java.awt.event.*; 

class Two extends JFrame {
  Two() {
    this.setVisible(true); 
    this.setSize(400, 500); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
  }
  public static void main(String[] args) {
    JFrame t = new Two(); 
    Three three = new Three(Integer.parseInt(args[0]));
    t.getContentPane().add( three ); 
  }
}

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x; 
    this.y = y; 
  }
}

class Circle{
  Point center;
  int radius;
  Color color; 
  Circle(Point a, int r, Color c) {
    this.center = a; 
    this.radius = r; 
    this.color = c; 
  } 
  void make(Color c) { this.color = c; } // [6] 
  void draw(Graphics g) {

    g.setColor(this.color); 
    g.fillOval(this.center.x - this.radius, 
               this.center.y - this.radius, 
               2 * this.radius, 2 * this.radius); 
    g.setColor(Color.BLACK); 
    g.drawOval(this.center.x - this.radius, 
               this.center.y - this.radius, 
               2 * this.radius, 2 * this.radius); 
  }
  void drawCircleOverlap(Graphics g) {

    g.setColor(Color.YELLOW); 
    g.fillOval(this.center.x - this.radius, 
               this.center.y - this.radius, 
               2 * this.radius, 2 * this.radius); 
    g.setColor(Color.BLUE); 
    g.drawOval(this.center.x - this.radius, 
               this.center.y - this.radius, 
               2 * this.radius, 2 * this.radius); 
  }
  boolean contains(Point where) {
    int dx = center.x; 
    int dy = center.y; 
    return this.distanceTo(where) < radius;
  }
  int distanceTo(Point where)
  {
    int dy = Math.abs(where.y - center.y);
    int dx = Math.abs(where.x - center.x);
    int distanceTo = (int) (Math.sqrt((dx * dx) + (dy * dy)));
   return distanceTo;    
  }
  void moveTo(Point where) {
    this.center = where; 
  } 
  public String toString() {
    return "Circle at " + this.center + " with radius " + this.radius; 
  }
}

class Three extends JComponent implements MouseListener, MouseMotionListener {
  public void mouseMoved(MouseEvent e) { } 
  public void mouseDragged(MouseEvent e) { 
    System.out.println( e.getX() + ", " + e.getY() );

    if (current != null) { 
      this.current.moveTo( new Point(e.getX(), e.getY()) );
      System.out.println( current ); 
      
      for(Circle r : this.shapes)
      {
        if(current.distanceTo(r.center) < current.radius + r.radius)
        {
          r.make(Color.YELLOW);       // [1]
          current.make(Color.YELLOW); // [2]
        } else {                      // [3]
          r.make(Color.WHITE);        // [4]
        }                             // [5]
      }
      repaint();
    }
  }
  public void mouseClicked(MouseEvent e) { } 

  Circle current;

  public void mousePressed(MouseEvent e) { 
    System.out.println( "Mouse pressed..." ); 
    Point mouse = new Point(e.getX(), e.getY()); 
    for (Circle r : this.shapes) {
      if (r.contains(mouse)) {
        this.current = r;
        break; 
      } 
    }
  } 
  public void mouseReleased(MouseEvent e) { 
    this.current = null; 
  } 
  public void mouseEntered(MouseEvent e) { } 
  public void mouseExited(MouseEvent e) { } 
  ArrayList<Circle> shapes; 
  Three(int size) {

    this.addMouseMotionListener( this ); 
    this.addMouseListener( this ); 

    this.shapes = new ArrayList<Circle>(); 
    for (int i = 0; i < size; i++) {
      Point where = new Point((int)(Math.random() * 300 + 50), 
                              (int)(Math.random() * 300 + 50)); 
      int radius = (int)(Math.random() * 50 + 20);
      Color color = new Color(255, 255, 255);
      this.shapes.add(new Circle(where, radius, color));
    } 
  }  
  public void paintComponent(Graphics g) {
    for (Circle r : this.shapes)
      r.draw( g ); 
  }
}
