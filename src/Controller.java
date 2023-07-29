import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Controller implements Runnable {
    private final ContentPane contentPane;
    private boolean flag;

    public Controller() {
        contentPane = new ContentPane();

        ActionListener addBall = ev -> addBall();
        ActionListener stop = ev -> stop();
        ActionListener clearScreen = ev -> clearScreen();

        contentPane.setAddBallButtonActionListener(addBall);
        contentPane.setStopButtonActionListener(stop);
        contentPane.setClearButtonActionListener(clearScreen);

        addBall();

        flag = true;
    }

    private void addBall() {
        Ball ball = new Ball((int) (Math.random() * 500) + 1, (int) (Math.random() * 400) + 1, (int) (Math.random() * 3) + 1, (int) (Math.random() * 3) + 1, getRandomColor());
        contentPane.getCanvas().addBall(ball);
    }

    private void stop() {
        flag = false;
    }

    private void clearScreen() {
        Iterator<Ball> it = contentPane.getCanvas().getBalls().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        contentPane.getFrame().repaint();
    }

    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    private void checkSides() {
        for (Ball ball : contentPane.getCanvas().getBalls()) {
            if (ball.getX() + 35 >= contentPane.getWidth())
                ball.setVelocityX(ball.getVelocityX() * -1);
            if (ball.getY() + 95 >= contentPane.getHeight())
                ball.setVelocityY(ball.getVelocityY() * -1);
            if (ball.getX() <= 0)
                ball.setVelocityX(ball.getVelocityX() * -1);
            if (ball.getY() <= 0)
                ball.setVelocityY(ball.getVelocityY() * -1);
        }
    }

    @Override
    public void run() {
        try {
            while (flag) {
                contentPane.getCanvas().run();
                checkSides();
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
