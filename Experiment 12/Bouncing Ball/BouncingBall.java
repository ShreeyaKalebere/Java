import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BallPanel panel = new BallPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}

class BallPanel extends JPanel implements Runnable {
    int x = 50, y = 50, radius = 20;
    int dx = 2, dy = 2;
    boolean moving = false;
    Thread ballThread;

    BallPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!moving) {
                    moving = true;
                    ballThread = new Thread(BallPanel.this);
                    ballThread.start();
                }
            }
        });
    }

    public void run() {
        while (true) {
            x += dx;
            y += dy;

            if (x < 0 || x > getWidth() - radius) dx = -dx;
            if (y < 0 || y > getHeight() - radius) dy = -dy;

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius);
    }
}
