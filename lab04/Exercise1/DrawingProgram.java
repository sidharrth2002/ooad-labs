import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingProgram extends JFrame {
    int oldX, oldY, newX, newY;  
    Image image;  
    Graphics2D output;

    class MoveListener implements MouseMotionListener {
        public void mouseMoved(MouseEvent e) {}
        
        public void mouseDragged(MouseEvent e) {
            newX = e.getX();
            newY = e.getY();
            output.setColor(Color.black);
            output.drawLine(oldX, oldY, newX, newY);
            repaint();
            oldX = newX;
            oldY = newY;
        }    
    }
    
    class PressListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
        }
    }

    class DrawingArea extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            if (image == null) {
                image = createImage(getSize().width, getSize().height);
                output = (Graphics2D) image.getGraphics();
            }
            g.drawImage(image, 0, 0, null);
        }    
    }


    public DrawingProgram() {
        super("Painter");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(new Label("Drag mouse to draw"));
        addMouseListener(new PressListener());
        addMouseMotionListener(new MoveListener());
        this.add(toolbar,BorderLayout.SOUTH);
        this.add(new DrawingArea(), BorderLayout.CENTER);
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] a){
        new DrawingProgram();
    }
}
