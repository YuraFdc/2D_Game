import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Window will not change it size
        window.setResizable(false);
        // Title of the window
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        // resize window to subcomponent (gamePanel)
        window.pack();

        // Do not set location of the window.
        // The window will display at the center of the screen
        window.setLocationRelativeTo(null);
        // Display window
        window.setVisible(true);
    }
}