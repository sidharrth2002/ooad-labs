import java.awt.event.*;
import java.awt.Toolkit;
public class SoundActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep(); 
    }
}