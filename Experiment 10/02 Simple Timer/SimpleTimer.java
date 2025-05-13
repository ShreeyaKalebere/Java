import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTimer extends JFrame implements ActionListener {

    JLabel timeLabel;
    JButton startButton, stopButton;
    Timer timer;
    int seconds = 0;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("Time: 0 seconds");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        add(startButton);
        add(stopButton);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        // Create Timer (fires every 1000 milliseconds = 1 second)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeLabel.setText("Time: " + seconds + " seconds");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        new SimpleTimer();
    }
}
