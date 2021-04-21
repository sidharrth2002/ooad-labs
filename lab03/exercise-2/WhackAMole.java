import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.border.LineBorder;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.AudioSystem;

public class WhackAMole extends JFrame {
    // private static final long serialVersionUID = 1L;
    long startTime = -1;
    long duration = 60000;
    //fires every 1 sec
    Timer timer = new Timer(100, new TimerActionListener());
    
    JLabel countdownLabel = new JLabel("60");
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");

    HashMap<Integer, JButton> gridButtons = new HashMap<Integer, JButton>();
    int numHits;
    JButton buttonWithMole;
    public static final Color DARKRED = new Color(153,0,0);

    private ImageIcon loadImage(String path) {
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(132, 132, java.awt.Image.SCALE_SMOOTH); return new ImageIcon(scaledImage);
    }

    private void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip(); 
            clip.open(audioInputStream); 
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
             ex.printStackTrace( );
        }
    }

    private void endGame() {
        timer.stop();
        int res = JOptionPane.showOptionDialog(null, "Number of successful whacks " + numHits, "Game Over", JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(res==0 || res==-1) {
            System.exit(0);
        }
    }

    private class TimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (startTime < 0) {
                startTime = System.currentTimeMillis();
            }

            long now = System.currentTimeMillis();
            long clockTime = now-startTime;

            if (clockTime >= duration) {
                clockTime = duration;
                endGame();
            }
            
            SimpleDateFormat df = new SimpleDateFormat("ss");
            countdownLabel.setText(df.format(duration-clockTime));

            if (clockTime % 2 == 0) {
                for (int j = 0; j < gridButtons.size(); j++) {
                    gridButtons.get(j).setIcon(null);
                }
                Random rnd = new Random(System.currentTimeMillis());
                int newVal = rnd.nextInt(9);
                gridButtons.get(newVal).setIcon(loadImage("./mole.png"));
                buttonWithMole = gridButtons.get(newVal);
            }
        }
    }

    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            timer.start();
            ((Button)e.getSource()).setEnabled(false);
        }
    }

    private class StopButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            endGame();
        }
    }

    private class MoleHitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getActionCommand();
            JButton btn = gridButtons.get(Integer.parseInt(command));

            if(buttonWithMole.equals(btn)) {
                playSound("whack.wav");
                numHits += 1;
                System.out.println(numHits);    
            }
        }
    }

    public WhackAMole() {
        super("Whack-a-mole");
        add(new JLabel("Sidharrth's Whack the Mole"));
        setSize(700, 700);
        setLayout(new FlowLayout());
        // JPanel jp = new JPanel();
        // add(jp);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(700, 200);
        startButton.addActionListener(new StartButtonListener());
        stopButton.addActionListener(new StopButtonListener());
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(countdownLabel);
        add(buttonPanel);

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setSize(700, 500);
        for(int i = 0; i < 9; i++) {
            JButton btn = new JButton();
            btn.addActionListener(new MoleHitListener());
            btn.setActionCommand(Integer.toString(i));
            btn.setPreferredSize(new Dimension((int)Math.floor(700/3), (int)Math.floor(500/3)));
            btn.setBackground(DARKRED);
            btn.setOpaque(true);
            btn.setBorder(new LineBorder(Color.BLACK));
            gridButtons.put(i, btn);
            gamePanel.add(btn);
        }
        add(gamePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WhackAMole();
    }
}