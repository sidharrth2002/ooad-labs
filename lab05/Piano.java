import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;

public class Piano implements ChangeListener, KeyListener {
    Synthesizer synth;
    MidiChannel[] mChannels;

    Piano() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            mChannels = synth.getChannels();
        } catch (MidiUnavailableException e) {
            JOptionPane.showMessageDialog(null, "Unable to open MIDI.");
        }

        JFrame frame = new JFrame("Pea-Air-Know");
        JButton[] w = new JButton[7];
        JButton[] b = new JButton[6];
        JLayeredPane panel = new JLayeredPane();
        frame.add(panel);

        for (int i = 0; i < 7; i++) {
            w[i] = new JButton();
            w[i].setName("White " + i);
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
            b[i].setBackground(Color.BLACK);
            b[i].setLocation(35 + i * 70, 0);
            b[i].setSize(70, 150);
            b[i].addKeyListener(this);
            b[i].addChangeListener(this);
            panel.add(b[i], 1, -1);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String keyName = ((JButton) e.getSource()).getName();

        int keyNum = 0;

        keyNum = 65 + Integer.parseInt(keyName.substring(6, 7));

        System.out.println(keyNum);

        synth.getChannels()[0].noteOn(keyNum, 127);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String keyName = ((JButton) e.getSource()).getName();

        int keyNum = 0;

        keyNum = 65 + Integer.parseInt(keyName.substring(6, 7));

        System.out.println(keyNum);

        synth.getChannels()[0].noteOff(keyNum, 127);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyCode());
        System.out.println(e.getKeyChar());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(synth.getChannels());
        String keyName = ((JButton) e.getSource()).getName();

        int keyNum = 0;

        keyNum = 65 + Integer.parseInt(keyName.substring(6, 7));

        System.out.println(keyNum);

        // synth.getChannels()[1].noteOn(keyNum, 127);
        // try {
        //     Thread.sleep(400);
        // } catch (InterruptedException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // }
        // synth.getChannels()[1].noteOff(keyNum);

    }


	public static void main(String[] args) {
		new Piano();	
	}
}