import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame implements ActionListener, Runnable {
    JLabel timeLabel;
    JButton startButton, stopButton, resetButton;
    Thread thread;
    int seconds = 0;
    boolean running = false;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        timeLabel = new JLabel("Time: 0 s");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        add(timeLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton && !running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        } else if (e.getSource() == stopButton) {
            running = false;
        } else if (e.getSource() == resetButton) {
            running = false;
            seconds = 0;
            timeLabel.setText("Time: 0 s");
        }
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                seconds++;
                timeLabel.setText("Time: " + seconds + " s");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}
