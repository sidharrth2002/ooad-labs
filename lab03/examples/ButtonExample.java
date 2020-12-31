import javax.swing.*;
import java.awt.*;

public class ButtonExample extends JFrame {
    public ButtonExample() {   
        super("Button Example");
        JPanel p = new JPanel();
        add(p);
        setSize(250,80);
        JButton pb = new JButton("Picture");
        JButton sb = new JButton("Sound");
        JButton fb = new JButton("File");
        p.add(pb);
        p.add(sb);
        p.add(fb);
        fb.addActionListener(new FileActionListener()); 
        pb.addActionListener(new PictureActionListener()); 
        sb.addActionListener(new SoundActionListener()); 
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    
    public static void main(String[] args) {
        new ButtonExample();
    }
}