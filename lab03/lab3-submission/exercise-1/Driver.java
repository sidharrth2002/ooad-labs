import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Driver extends JFrame
{
    
    public Driver()
    {
        super("This is the application");
        JPanel jp = new JPanel(new FlowLayout());
        add(jp);
        setSize(400, 300);
        
        JButton pushMeButton = new JButton("Push me");
        JButton clickMeButton = new JButton("Click me");
        pushMeButton.addActionListener(new ButtonClickListener());
        clickMeButton.addActionListener(new ButtonClickListener());
        jp.add(pushMeButton);
        jp.add(clickMeButton);
        
        
        for (int i=0; i<4;i++) {
            JButton btnArr = new JButton("Button " + i);
            btnArr.addActionListener(new ButtonClickListener());
            jp.add(btnArr);
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Driver();
    }
    
       private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String btn = evt.getActionCommand();            
            switch(btn) {            
                case "Push me":
                    JOptionPane.showMessageDialog(null, "A button was pushed");
                    break;
                case "Click me":
                    JOptionPane.showMessageDialog(null, "B button was clicked");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, btn + " was pushed!"); 
            }
        }
    }

}
