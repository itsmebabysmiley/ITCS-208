import javax.swing.JFrame;
import java.awt.*;

public class Draw extends JFrame {
    public Draw() {
        setTitle("Draw Something");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    }
    public void paint(Graphics graphics) {
        
        graphics.setColor(Color.BLUE);
        graphics.drawOval(200, 200, 100, 100);
        //graphics.fillOval(20, 20, 100, 100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(40, 40, 100, 100);
        //graphics.fillRect(x, y, width, height);
    }
    public static void main(String[] args) {
        Draw d = new Draw();
        d.paint(null);
    }
    
    
}
