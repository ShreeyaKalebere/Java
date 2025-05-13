import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseCoordinatesTracker extends JFrame implements MouseMotionListener {

    JLabel coordinatesLabel;

    public MouseCoordinatesTracker() {
        setTitle("Mouse Coordinates Tracker");
        setSize(400, 300);
        setLayout(new FlowLayout());

        coordinatesLabel = new JLabel("Move the mouse inside the window");
        add(coordinatesLabel);

        addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mouseMoved(MouseEvent e) {
        coordinatesLabel.setText("Mouse Coordinates: X = " + e.getX() + ", Y = " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {
    }

    public static void main(String[] args) {
        new MouseCoordinatesTracker();
    }
}
