import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.add(new JLabel("Enter the number"));
        JTextField input = new JTextField(10);
        top.add(input);
        frame.add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1, 3));
        JButton binary = new JButton("Binary");
        JButton octal = new JButton("Octal");
        JButton hex = new JButton("Hex");
        center.add(binary);
        center.add(octal);
        center.add(hex);
        frame.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Result"));
        JTextField result = new JTextField(10);
        result.setEditable(false);
        bottom.add(result);
        frame.add(bottom, BorderLayout.SOUTH);

        binary.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText());
                result.setText(Integer.toBinaryString(n));
            } catch (Exception ex) {
                result.setText("Invalid");
            }
        });

        octal.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText());
                result.setText(Integer.toOctalString(n));
            } catch (Exception ex) {
                result.setText("Invalid");
            }
        });

        hex.addActionListener(e -> {
            try {
                int n = Integer.parseInt(input.getText());
                result.setText(Integer.toHexString(n).toUpperCase());
            } catch (Exception ex) {
                result.setText("Invalid");
            }
        });

        frame.setVisible(true);
    }
}
