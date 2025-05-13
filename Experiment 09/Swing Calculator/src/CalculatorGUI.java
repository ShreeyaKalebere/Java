import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";
    boolean startNew = true;

    public CalculatorGUI() {
        setTitle("Standard Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
                "C", "√", "x²", "%",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) {
            if (startNew) {
                display.setText(command);
                startNew = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
            startNew = true;
        } else if (command.equals("x²")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(val * val));
                startNew = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (command.equals("√")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(val)));
                startNew = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (command.equals("%")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(val / 100));
                startNew = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (command.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num2 != 0 ? num1 / num2 : 0; break;
                }

                display.setText(String.valueOf(result));
                startNew = true;
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                startNew = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
