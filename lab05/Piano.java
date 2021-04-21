import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;

public class Piano implements ChangeListener, KeyListener {
    Synthesizer synth;
    MidiChannel[] mChannels;

    boolean isPlaying;
    int key;
    int typeOfSound = 1;
    int volume = 127;

    Piano() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            mChannels = synth.getChannels();
        } catch (MidiUnavailableException e) {
            JOptionPane.showMessageDialog(null, "Unable to open MIDI.");
        }

        JFrame frame = new JFrame("Pea-Air-Know");
        // frame.setLayout(new FlowLayout());
        JButton[] w = new JButton[7];
        JButton[] b = new JButton[6];
        JLayeredPane panel = new JLayeredPane();
        JPanel menuOptions = new JPanel();

        JLabel label = new JLabel("Adjust Volume");
        JSlider volSlider = new JSlider(0, 500, 127);
        volSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    volume = (int)source.getValue();
                    System.out.println(volume);
                }    
            }
        });
        menuOptions.add(label);
        menuOptions.add(volSlider);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(menuOptions, BorderLayout.SOUTH);

        for (int i = 0; i < 7; i++) {
            w[i] = new JButton();
            w[i].setName("White " + i);
            w[i].setOpaque(true);
            w[i].setBackground(Color.WHITE);
            w[i].setLocation(i * 70, 0);
            w[i].setSize(70, 300);
            w[i].addKeyListener(this);
            w[i].addChangeListener(this);
            panel.add(w[i], 0, -1);
        }

        for (int i = 0; i < 6; i++) {
            if (i == 2)
                continue;
            b[i] = new JButton();
            b[i].setName("Black " + i);
            b[i].setOpaque(true);
            b[i].setBackground(Color.BLACK);
            b[i].setLocation(35 + i * 70, 0);
            b[i].setSize(70, 150);
            b[i].addKeyListener(this);
            b[i].addChangeListener(this);
            panel.add(b[i], 1, -1);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        isPlaying = true;
        synth.getChannels()[0].noteOn(key, volume);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (isPlaying) {
            synth.getChannels()[0].noteOff(key);
            isPlaying = true;
        }

    }

    // zxcvbnm
    // sd ghj

    @Override
    public void keyTyped(KeyEvent e) {
        char keyName = e.getKeyChar();
        System.out.println(keyName + " pressed");
            isPlaying = true;
            switch(keyName) {
                case 'z':
                    key = 60;
                    break;
                case 's':
                    key = 61;
                    break;
                case 'x':
                    key = 62;
                    break;
                case 'd':
                    key = 63;
                    break;
                case 'c':
                    key = 64;
                    break;
                case 'v':
                    key = 65;
                    break;
                case 'g':
                    key = 66;
                    break;
                case 'b':
                    key = 67;
                    break;
                case 'h':
                    key = 68;
                    break;
                case 'n':
                    key = 69;
                    break;
                case 'j':
                    key = 70;
                    break;
                case 'm':
                    key = 71;
                    break;
                default:
                    key = 0;
            }
        }

    // zxcvbnm
    // sd ghj

    @Override
    public void stateChanged(ChangeEvent e) {
        JButton buttonPressed = (JButton) e.getSource();
        String keyName = buttonPressed.getName();
        if (buttonPressed.getModel().isPressed()) {
            System.out.println(keyName + " pressed");
            isPlaying = true;
            switch(keyName) {
                case "White 0":
                    key = 60;
                    break;
                case "Black 0":
                    key = 61;
                    break;
                case "White 1":
                    key = 62;
                    break;
                case "Black 1":
                    key = 63;
                    break;
                case "White 2":
                    key = 64;
                    break;
                case "White 3":
                    key = 65;
                    break;
                case "Black 2":
                    key = 66;
                    break;
                case "White 4":
                    key = 67;
                    break;
                case "Black 3":
                    key = 68;
                    break;
                case "White 5":
                    key = 69;
                    break;
                case "Black 4":
                    key = 70;
                    break;
                case "White 6":
                    key = 71;
                    break;
            }
            if (key != 0) {
                synth.getChannels()[typeOfSound].noteOn(key, volume);
            }
        } else {
            if (isPlaying) {
                synth.getChannels()[typeOfSound].noteOff(key);
            }
            isPlaying = false;
        }
    }


	public static void main(String[] args) {
		new Piano();	
	}
}