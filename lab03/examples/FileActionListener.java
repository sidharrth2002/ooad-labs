import java.awt.event.*;
import javax.swing.JFileChooser;
public class FileActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int r = fc.showOpenDialog(null);
    }
}