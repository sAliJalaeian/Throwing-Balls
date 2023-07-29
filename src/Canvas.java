import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private final ArrayList<Ball> balls;

    public Canvas() {
        balls = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls)
            ball.paint(g);
    }

    public void run() {
        for (Ball ball : balls) {
            ball.move();
            repaint();
        }
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }
}
