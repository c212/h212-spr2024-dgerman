import javax.swing.JFrame; 
import javax.swing.JComponent; 
import java.awt.Graphics;
import java.util.ArrayList; 
import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Eight extends JComponent implements MouseMotionListener,
                                                 MouseListener {

  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  public void mouseClicked(MouseEvent e) { }
  Circle current;
  public void mousePressed(MouseEvent e) { 
    int x = e.getX(), y = e.getY(); 
    for (Circle c : circles) {
      if (c.contains(x, y)) {
        this.current = c;
        break;
      }
    }
    System.out.println(this.current); 
  }
  public void mouseReleased(MouseEvent e) { }

  public void mouseMoved(MouseEvent e) { }

  public void mouseDragged(MouseEvent e) { 
    if (current != null) {
      int x = e.getX(), y = e.getY(); 
      this.current.x = x;
      this.current.y = y;

      this.repaint();
    }
  }

  ArrayList<Circle> circles = new ArrayList<Circle>(); 

  public Eight() {
    for (int i = 0; i < 10; i++) {
      this.circles.add(new Circle((int)(Math.random()*400), 
                                  (int)(Math.random()*400), 
                                  (int)(Math.random() * 10 + 30),
                                  new Color((float)Math.random(), 
                                            (float)Math.random(), 
                                            (float)Math.random())));  
    }
    this.addMouseMotionListener(this); 
    this.addMouseListener(this); 
  }

  public void paintComponent(Graphics g) {
    for (Circle c : this.circles)
      c.draw(g); 
  }
  public static void main(String[] args) {
    JFrame a = new JFrame(); 
    a.add( new Eight() ); 
    a.setSize(400, 400); 
    a.setVisible(true); 
  }
}
