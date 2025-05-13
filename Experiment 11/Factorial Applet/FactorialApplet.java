import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialApplet extends Applet implements ActionListener {
    TextField input, result;
    Button find;

    public void init() {
        Label l1 = new Label("Enter number:");
        input = new TextField(10);
        find = new Button("Find Factorial");
        Label l2 = new Label("Result:");
        result = new TextField(10);
        result.setEditable(false);

        add(l1);
        add(input);
        add(find);
        add(l2);
        add(result);

        find.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(input.getText());
            int f = 1;
            for (int i = 1; i <= n; i++) {
                f = f * i;
            }
            result.setText(String.valueOf(f));
        } catch (Exception ex) {
            result.setText("Invalid");
        }
    }
}
