import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import javax.swing.colorchooser.*;

public class DrawingProgram2 extends JFrame implements MouseListener {
    int oldX, oldY, newX, newY;  
    Image image;  
    Graphics2D output;
    int eraser;

    class MoveListener implements MouseMotionListener {
        public void mouseMoved(MouseEvent e) {}
        
        public void mouseDragged(MouseEvent e) {
            newX = e.getX();
            newY = e.getY();
            // output.setColor(Color.black);
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
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton((MouseEvent) e)) {
                if (eraser == 1) {
                    eraser = 0;
                    output.setColor(Color.BLACK);
                } else {
                    eraser = 1;
                    output.setColor(getBackground());
                }    
            }
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


    public DrawingProgram2() {
        super("Painter");
        
        //add movement listeners for mouse
        addMouseListener(new PressListener());
        addMouseMotionListener(new MoveListener());

        //initialise toolbar and color chooser
        JPanel toolbar = new JPanel();
        JButton changeColorButton = new JButton("Change colour");
        changeColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newCol = JColorChooser.showDialog(null, "Choose the colour.", output.getColor()); 
                output.setColor(newCol);
            }
        });

        JButton eraserButton = new JButton("Eraser Toggle Or Right Click");
        eraserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (eraser == 1) {
                    eraser = 0;
                    output.setColor(Color.BLACK);
                } else {
                    eraser = 1;
                    output.setColor(getBackground());
                }
            }
        });

        JSlider sample = new JSlider(JSlider.HORIZONTAL, 1, 8, 4);
        sample.setMajorTickSpacing(10);
        sample.setMinorTickSpacing(1);
        sample.setPaintTicks(true);
        sample.setPaintLabels(true);
        sample.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int) source.getValue();
                    if (fps != 0) {
                        output.setStroke(new BasicStroke(fps));
                    }
                }
            }
        });

        DrawingArea drawingArea = new DrawingArea();
        // output.setColor(Color.BLACK);

        //add label
        toolbar.add(new Label("Drag mouses to draw"));
        toolbar.add(changeColorButton);
        toolbar.add(sample);
        toolbar.add(eraserButton);

        //add to panel
        this.add(toolbar,BorderLayout.NORTH);
        this.add(drawingArea, BorderLayout.CENTER);

        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new DrawingProgram2();
    }
}