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

    Thread gameThread;

    public GamePanel() {
        // set the size of this class (JPanel)
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        // Set background color
        this.setBackground(Color.BLACK);
        // If set true, all the drawing from this component will be done in an offscreen painting buffer
        this.setDoubleBuffered(true);
    }

    public void startGameThreat() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Create gae loop

    }
}
