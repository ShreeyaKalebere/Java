import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextStatsTracker extends JFrame implements KeyListener {

    JTextArea textArea;
    JLabel statsLabel;

    public TextStatsTracker() {
        setTitle("Live Text Stats");
        setSize(400, 300);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.addKeyListener(this);

        statsLabel = new JLabel("Characters: 0 | Words: 0");
        statsLabel.setFont(new Font("Arial", Font.BOLD, 14));

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(statsLabel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        updateStats();
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    private void updateStats() {
        String text = textArea.getText();

        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;

        statsLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
    }

    public static void main(String[] args) {
        new TextStatsTracker();
    }
}
