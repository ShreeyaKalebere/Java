import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApp extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton upButton, downButton, resetButton;
    private int count = 0;

    public CounterApp() {
        setTitle("Counter GUI");

        label = new JLabel("Counter");
        textField = new JTextField("0", 10);
        textField.setEditable(false);

        upButton = new JButton("Count Up");
        downButton = new JButton("Count Down");
        resetButton = new JButton("Reset");

        upButton.addActionListener(this);
        downButton.addActionListener(this);
        resetButton.addActionListener(this);

        setLayout(new FlowLayout());

        add(label);
        add(textField);
        add(upButton);
        add(downButton);
        add(resetButton);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == upButton) {
            count++;
        } else if (e.getSource() == downButton) {
            count--;
        } else if (e.getSource() == resetButton) {
            count = 0;
        }
        textField.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}
