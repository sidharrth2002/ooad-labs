import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FileHandlingTest extends JFrame
{
    
    public FileHandlingTest()
    {
        super("This is the application");
        JPanel jp = new JPanel(new FlowLayout());
        add(jp);
        setSize(400, 300);
        
        JButton pushMeButton = new JButton("Push me");
        JButton uploadButton = new JButton("Upload File");
        pushMeButton.addActionListener(new ButtonClickListener());
        uploadButton.addActionListener(new FileActionListener());
        jp.add(pushMeButton);
        jp.add(uploadButton);
        
        
        for (int i=0; i<4;i++) {
            JButton btnArr = new JButton("Button " + i);
            btnArr.addActionListener(new ButtonClickListener());
            jp.add(btnArr);
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new FileHandlingTest();
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

    private class FileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int r = fc.showOpenDialog(null);   
            if (r == JFileChooser.APPROVE_OPTION) {
                System.out.println(fc.getSelectedFile().getAbsolutePath());
            }     
        }
    }

}
