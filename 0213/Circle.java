import java.awt.Color; 
import java.awt.Graphics; 

public class Circle {

  int x, y; 
  int radius;
  Color c;

  public String toString() {
    return this.c + " circle (" + this.x + ", " + this.y + ") with radius + " + this.radius;  
  } // I needed this for debugging 

  public Circle(int x, int y, int r, Color c) {
    this.x = x; 
    this.y = y; 
    this.radius = r;
    this.c = c; 
  }

  public void draw(Graphics g) {
    g.setColor(this.c); 
    g.fillOval(this.x - this.radius, 
               this.y - this.radius, 
               this.radius * 2, 
               this.radius * 2);  
    g.setColor(Color.BLACK);     
    g.drawOval(this.x - this.radius, 
               this.y - this.radius, 
               this.radius * 2, 
               this.radius * 2);  
    
  }

  public boolean contains(int x, int y) {
    int dx = this.x - x, dy = this.y - y;
    double d = Math.sqrt(dx*dx + dy*dy);
    return d <= this.radius;
  }

}
