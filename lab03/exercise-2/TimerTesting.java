import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class TimerTesting extends JFrame {
    int timeLeft = 60000;
    Timer timer = new Timer(100, new TimerActionListener());
    JLabel timerLabel = new JLabel();
    JLabel BigText = new JLabel("Time Up!");

    public TimerTesting() {
        super("Timer Testing");
        setSize(500, 500);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("JPanel testing"));
        mainPanel.add(timerLabel);
        mainPanel.setSize(500, 100);

        JPanel announcementPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        BigText.setFont(new Font("Serif", Font.BOLD, 20));
        BigText.setVisible(false);
        announcementPanel.setSize(500, 400);
        announcementPanel.add(BigText);
        timer.start();

        add(mainPanel, BorderLayout.NORTH);
        add(announcementPanel, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(timeLeft);
            timeLeft -= 100;
            if(timeLeft < 0) {
                timer.stop();
                System.out.println("It's over");
                BigText.setVisible(true);
            } else {
                SimpleDateFormat df=new SimpleDateFormat("ss");
                timerLabel.setText(df.format(timeLeft));    
            }
        }
    }

    public static void main(String[] args) {
        new TimerTesting();
    }
}
