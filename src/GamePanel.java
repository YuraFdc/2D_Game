import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // Screen settings
    final int originalTileSize = 16; // 16x16 tile of any character or object
    // Set scale for modern monitors
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48 x 48 tile
    // How many tiles can be displayed on a single screen horizontally and vertically
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    // FPS
    int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        // set the size of this class (JPanel)
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        // Set background color
        this.setBackground(Color.BLACK);
        // If set true, all the drawing from this component will be done in an offscreen painting buffer
        this.setDoubleBuffered(true);
        //
        this.addKeyListener(keyH);
        // GamePanel can be focused to receive key input
        this.setFocusable(true);
    }

    public void startGameThreat() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Create gae loop
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                // UPDATE information such as character position
                update();

                // DRAW the screen with the updated information
                repaint(); // call paintComponent method

                delta--;
            }
        }
    }

    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;

        g2.setColor(Color.WHITE); // Set white color to use for drawing objects
        // paint a square on the screen
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        // after drawing free system resources
        g2.dispose();
    }
}
