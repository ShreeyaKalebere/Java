import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxExample extends JFrame implements ActionListener {

    JLabel l;
    JCheckBox cb1, cb2, cb3;
    JButton b;

    CheckBoxExample() {
        setTitle("Stationery Purchase System");

        l = new JLabel("Stationery Purchase System");
        l.setBounds(50, 50, 300, 20);

        cb1 = new JCheckBox("Notebook @ 50");
        cb1.setBounds(100, 100, 150, 20);

        cb2 = new JCheckBox("Pen @ 30");
        cb2.setBounds(100, 150, 150, 20);

        cb3 = new JCheckBox("Pencil @ 10");
        cb3.setBounds(100, 200, 150, 20);

        b = new JButton("Order");
        b.setBounds(100, 250, 80, 30);
        b.addActionListener(this);

        add(l);
        add(cb1);
        add(cb2);
        add(cb3);
        add(b);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        String msg = "";

        if (cb1.isSelected()) {
            int q = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Quantity for Notebook"));
            amount += 50 * q;
            msg += "Notebook Quantity: " + q + "  Total: " + (50 * q) + "\n";
        }

        if (cb2.isSelected()) {
            int q = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Quantity for Pen"));
            amount += 30 * q;
            msg += "Pen Quantity: " + q + "  Total: " + (30 * q) + "\n";
        }

        if (cb3.isSelected()) {
            int q = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Quantity for Pencil"));
            amount += 10 * q;
            msg += "Pencil Quantity: " + q + "  Total: " + (10 * q) + "\n";
        }

        msg += "---------------------------\n";
        msg += "Total Amount: ₹" + amount;

        JOptionPane.showMessageDialog(this, msg);
        JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new CheckBoxExample();
    }
}
