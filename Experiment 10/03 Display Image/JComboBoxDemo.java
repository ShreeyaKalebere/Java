import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxDemo extends JFrame implements ItemListener {

    JLabel imageLabel;

    public JComboBoxDemo() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Dog");
        comboBox.addItem("Cat");
        comboBox.addItem("Horse");
        comboBox.addItem("Lion");

        comboBox.addItemListener(this);

        contentPane.add(comboBox);

        imageLabel = new JLabel();
        contentPane.add(imageLabel);

        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        String selectedItem = (String) e.getItem();
        ImageIcon imageIcon = new ImageIcon(selectedItem + ".jpg");

        if (imageIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
            imageLabel.setText("Image not found!");
        } else {
            imageLabel.setIcon(imageIcon);
        }
    }

    public static void main(String[] args) {
        new JComboBoxDemo();
    }
}
