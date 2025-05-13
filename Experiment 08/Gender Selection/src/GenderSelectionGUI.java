import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenderSelectionGUI extends JFrame implements ActionListener {
    JRadioButton maleButton, femaleButton, otherButton;
    ButtonGroup genderGroup;
    JLabel label;
    JButton submitButton;
    JTextField resultField;

    public GenderSelectionGUI() {
        setTitle("Gender Selection");

        label = new JLabel("Select Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        // Group the radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        resultField = new JTextField(20);
        resultField.setEditable(false);

        // Set layout and add components
        setLayout(new FlowLayout());
        setSize(400, 200);

        add(label);
        add(maleButton);
        add(femaleButton);
        add(otherButton);
        add(submitButton);
        add(resultField);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String selected = "";
        if (maleButton.isSelected()) {
            selected = "Male";
        } else if (femaleButton.isSelected()) {
            selected = "Female";
        } else if (otherButton.isSelected()) {
            selected = "Other";
        } else {
            selected = "No option selected";
        }

        resultField.setText("Selected Gender: " + selected);
    }

    public static void main(String[] args) {
        new GenderSelectionGUI();
    }
}
