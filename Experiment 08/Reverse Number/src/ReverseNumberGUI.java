import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumberGUI extends JFrame implements ActionListener {

    JLabel label1, label2;
    JTextField inputField, outputField;
    JButton reverseButton;

    public ReverseNumberGUI() {
        setTitle("Reverse Number");

        label1 = new JLabel("Enter Number:");
        inputField = new JTextField(15);

        label2 = new JLabel("Reversed:");
        outputField = new JTextField(15);
        outputField.setEditable(false);

        reverseButton = new JButton("Reverse");

        setSize(400, 200);
        setLayout(new FlowLayout());

        add(label1);
        add(inputField);
        add(label2);
        add(outputField);
        add(reverseButton);

        reverseButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputField.getText());
            int reversed = 0;

            while (number != 0) {
                reversed = reversed * 10 + number % 10;
                number = number / 10;
            }

            outputField.setText(String.valueOf(reversed));
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new ReverseNumberGUI();
    }
}
