import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SomethingWindow extends JFrame
{
    private class AButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "A button was pushed");
        }
    }
    
    public SomethingWindow()
    {
        super("This is my application");
        JPanel jp=new JPanel(new FlowLayout());
        add(jp);
        setSize(320,150);
        setVisible(true);
        JButton bButton;
        bButton = new JButton();
        bButton.addActionListener(new AButtonActionListener());
        bButton.setText("Click me");
        jp.add(bButton);
        
        /*
        for (int x=0; x<4;x++) {
            JButton btnArr = new JButton("Button " + x);
            jp.add(btnArr);
        }
        */
       
       JButton[] btn = new JButton[4];
       for(int x=0; x<4;x++) {
           btn[x] = new JButton("Buttons " + x);
           jp.add(btn[x]);
        }
        
        System.out.println(btn);
       
        
    }
    public static void main(String[] args)
    {
        new SomethingWindow();
    }
}