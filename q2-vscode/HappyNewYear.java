import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.*;  

public class HappyNewYear extends JFrame implements ActionListener {
    JTextField messageField;
    DisplayArea displayArea = new DisplayArea();
    JLabel displayText = new JLabel("This will change when you generate.");
    int fontSize = 20;

    public HappyNewYear() {
        //frame title
        super("Prepare a Pretty New Year's Message");
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //field to take in the new message
        JLabel messageLabel = new JLabel("Enter your new year message: ");
        messageField = new JTextField(10);        
        optionsPanel.add(messageLabel);
        optionsPanel.add(messageField);
        JButton submitButton = new JButton("Generate");
        
        //slider to change size of the text
        JSlider slider = new JSlider();
        displayText.setFont(new Font("Century Gothic", Font.BOLD, fontSize));
        slider.setMajorTickSpacing(80);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int) source.getValue();
                    fontSize = fps;
                    displayText.setFont(new Font("Century Gothic", Font.BOLD, fontSize));
                }
            }
        });

        //button to change color of the text
        JButton changeColorButton = new JButton("Change colour");
        changeColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newCol = JColorChooser.showDialog(null, "Choose the colour.", displayText.getForeground()); 
                displayText.setForeground(newCol);
            }
        });
        
        submitButton.addActionListener(this);
        optionsPanel.add(submitButton);
        optionsPanel.add(new JLabel("Change the Font: "));
        optionsPanel.add(slider);
        optionsPanel.add(changeColorButton);

        add(optionsPanel, BorderLayout.NORTH);
        // displayArea.setSize(300, 300);
        displayArea.add(displayText);
        add(displayArea, BorderLayout.CENTER);
        setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //use this class to display image
    public class DisplayArea extends JPanel {
        private Image image;

        public DisplayArea() {
            try {                
                BufferedImage buffimage = ImageIO.read(new File("happynewyear.jpg"));
                image = buffimage.getScaledInstance(550, 400, Image.SCALE_SMOOTH);
            } catch (IOException ex) {
                 ex.printStackTrace();
            }
        }

        //paints the image onto the panel
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 200, 150, this);          
        }
    }

    public static void main(String[] args) {
        new HappyNewYear();
    }

    //gets the message and changes the display text
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageField.getText();
        displayText.setText(message);
    }
}