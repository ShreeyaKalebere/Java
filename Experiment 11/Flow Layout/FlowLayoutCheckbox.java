import java.awt.*;
import javax.swing.*;

public class FlowLayoutCheckbox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JCheckBox java = new JCheckBox("Java");
        JCheckBox python = new JCheckBox("Python");
        JCheckBox cpp = new JCheckBox("C++");

        frame.add(java);
        frame.add(python);
        frame.add(cpp);

        frame.setVisible(true);
    }
}
