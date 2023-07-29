import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContentPane {
    private JFrame frame;
    private JButton addBall;
    private JButton stop;
    private JButton clearScreen;
    private final int width, height;
    private Canvas canvas;

    public ContentPane() {
        width = 600;
        height = 500;
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Balls");
        Container contentPane = frame.getContentPane();

        canvas = new Canvas();
        contentPane.add(canvas);

        addBall = new JButton("Add Ball");
        stop = new JButton("Stop");
        clearScreen = new JButton("Clear Screen");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(stop);
        buttonsPanel.add(addBall);
        buttonsPanel.add(clearScreen);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setAddBallButtonActionListener(ActionListener listener) {
        addBall.addActionListener(listener);
    }

    public void setStopButtonActionListener(ActionListener listener) {
        stop.addActionListener(listener);
    }

    public void setClearButtonActionListener(ActionListener listener) {
        clearScreen.addActionListener(listener);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JFrame getFrame() {
        return frame;
    }
}
