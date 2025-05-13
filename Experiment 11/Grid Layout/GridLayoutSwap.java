import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutSwap {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swap with 1");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 3));

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");

        JButton[] buttons = {b1, b2, b3, b4, b5, b6};

        for (JButton b : buttons) {
            frame.add(b);
            b.addActionListener(e -> {
                JButton clicked = (JButton) e.getSource();
                if (!clicked.getText().equals("1")) {
                    for (JButton x : buttons) {
                        if (x.getText().equals("1")) {
                            String temp = clicked.getText();
                            clicked.setText("1");
                            x.setText(temp);
                            break;
                        }
                    }
                }
            });
        }

        frame.setVisible(true);
    }
}
