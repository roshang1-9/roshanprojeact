import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.RenderingHints;
import java.util.*;

public class snakegame1 extends JFrame {
    public snakegame1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Snake Game");
        setLocationRelativeTo(null);
        
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new snakegame1());
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int TILE_SIZE = 20;
    private static final int TILES_X = WIDTH / TILE_SIZE;
    private static final int TILES_Y = HEIGHT / TILE_SIZE;
    private static final int INITIAL_DELAY = 100;

    private ArrayList<Point> snake;
    private Point food;
    private int direction = KeyEvent.VK_RIGHT;
    private int nextDirection = KeyEvent.VK_RIGHT;
    private boolean gameOver = false;
    private boolean paused = false;
    private int score = 0;
    private int highScore = 0;
    private int foodEaten = 0;
    private boolean shouldGrow = false; // Flag to grow snake on next move
    private String collisionType = ""; // Track what caused game over
    // Use fully-qualified name to avoid ambiguity with java.util.Timer
    private javax.swing.Timer gameTimer;
    private String snakeHeadEmoji = "😎"; // Emoji for snake head

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake = new ArrayList<>();
        snake.add(new Point(TILES_X / 2, TILES_Y / 2));
        snake.add(new Point(TILES_X / 2 - 1, TILES_Y / 2));
        snake.add(new Point(TILES_X / 2 - 2, TILES_Y / 2));

        spawnFood();

        // Use javax.swing.Timer so the compiler doesn't confuse it with java.util.Timer
        gameTimer = new javax.swing.Timer(INITIAL_DELAY, this);
        gameTimer.start();
    }

    private int getCurrentDelay() {
        // Increase speed by 2ms for every 30 points (every 3 food eaten)
        int speedBonus = (foodEaten / 3) * 2;
        int newDelay = Math.max(40, INITIAL_DELAY - speedBonus);
        return newDelay;
    }

    private void spawnFood() {
        Random rand = new Random();
        Point newFood;
        do {
            newFood = new Point(rand.nextInt(TILES_X), rand.nextInt(TILES_Y));
        } while (snake.contains(newFood));
        food = newFood;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) {
            direction = nextDirection;
            moveSnake();
            checkCollisions();
            checkFoodCollision();
            
            // Adjust timer speed based on score
            int currentDelay = getCurrentDelay();
            if (currentDelay != gameTimer.getDelay()) {
                gameTimer.setDelay(currentDelay);
            }
        }
        repaint();
    }

    private void moveSnake() {
        Point head = snake.get(0);
        Point newHead = new Point(head.x, head.y);

        switch (direction) {
            case KeyEvent.VK_RIGHT:
                newHead.x++;
                break;
            case KeyEvent.VK_LEFT:
                newHead.x--;
                break;
            case KeyEvent.VK_UP:
                newHead.y--;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y++;
                break;
        }

        // Add new head
        snake.add(0, newHead);
        
        // Only remove tail if not growing (when food was eaten)
        if (!shouldGrow) {
            snake.remove(snake.size() - 1);
        } else {
            shouldGrow = false; // Reset growth flag after growing
        }
    }

    private void checkCollisions() {
        Point head = snake.get(0);

        // Check wall collision (boundaries)
        if (head.x < 0 || head.x >= TILES_X || head.y < 0 || head.y >= TILES_Y) {
            System.out.println("Wall collision detected! Head at (" + head.x + ", " + head.y + ")");
            System.out.println("Valid range: x=[0," + (TILES_X-1) + "], y=[0," + (TILES_Y-1) + "]");
            collisionType = "HIT WALL";
            gameOver = true;
            gameTimer.stop();
            return;
        }

        // Check self collision (snake cannot occupy same space as its body)
        // Start from index 1 to skip the head itself
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                System.out.println("Self collision detected! Head at (" + head.x + ", " + head.y + ") hits body segment " + i);
                collisionType = "HIT YOURSELF";
                gameOver = true;
                gameTimer.stop();
                return;
            }
        }
    }

    private void checkFoodCollision() {
        if (snake.get(0).equals(food)) {
            score += 10;
            foodEaten++;
            if (score > highScore) {
                highScore = score;
            }
            shouldGrow = true; // Flag to grow on next move
            spawnFood();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw boundary lines (grid)
        g2d.setColor(new Color(50, 50, 50));
        g2d.setStroke(new BasicStroke(1));
        for (int i = 0; i <= TILES_X; i++) {
            g2d.drawLine(i * TILE_SIZE, 0, i * TILE_SIZE, HEIGHT);
        }
        for (int i = 0; i <= TILES_Y; i++) {
            g2d.drawLine(0, i * TILE_SIZE, WIDTH, i * TILE_SIZE);
        }

        // Draw outer boundary (thicker)
        g2d.setColor(Color.CYAN);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);

        // Draw snake body
        g2d.setColor(Color.GREEN);
        for (int i = 1; i < snake.size(); i++) {
            Point segment = snake.get(i);
            g2d.fillRect(segment.x * TILE_SIZE, segment.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        }

        // Draw snake head with emoji
        Point headPos = snake.get(0);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(headPos.x * TILE_SIZE, headPos.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        g2d.setFont(new Font("Arial", Font.PLAIN, TILE_SIZE - 4));
        g2d.setColor(Color.BLACK);
        FontMetrics fm = g2d.getFontMetrics();
        int x = headPos.x * TILE_SIZE + (TILE_SIZE - fm.stringWidth(snakeHeadEmoji)) / 2;
        int y = headPos.y * TILE_SIZE + ((TILE_SIZE - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(snakeHeadEmoji, x, y);

        // Draw food
        g2d.setColor(Color.RED);
        g2d.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        g2d.setFont(new Font("Arial", Font.PLAIN, TILE_SIZE - 6));
        g2d.setColor(Color.YELLOW);
        x = food.x * TILE_SIZE + (TILE_SIZE - fm.stringWidth("❤")) / 2;
        y = food.y * TILE_SIZE + ((TILE_SIZE - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString("❤", x, y);

        // Draw score and high score
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Score: " + score, 10, HEIGHT - 25);
        g2d.drawString("High Score: " + highScore, 10, HEIGHT - 10);

        // Draw current speed
        int speedLevel = (foodEaten / 3) + 1;
        g2d.drawString("Speed: " + speedLevel, WIDTH - 120, HEIGHT - 10);

        // Draw paused message
        if (paused && !gameOver) {
            g2d.setColor(new Color(255, 255, 0, 200));
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            String pausedText = "PAUSED";
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(pausedText)) / 2;
            int y_pos = (HEIGHT / 2) - 30;
            g2d.drawString(pausedText, x, y_pos);
            
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            String resumeText = "Press P to Resume";
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(resumeText)) / 2;
            g2d.drawString(resumeText, x, y_pos + 30);
        }

        // Draw game over message
        if (gameOver) {
            g2d.setColor(new Color(255, 255, 255, 200));
            g2d.fillRect(0, 0, WIDTH, HEIGHT);
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            String gameOverText = "GAME OVER";
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(gameOverText)) / 2;
            int y_pos = (HEIGHT - fm.getHeight()) / 2 + fm.getAscent();
            g2d.drawString(gameOverText, x, y_pos);

            g2d.setFont(new Font("Arial", Font.PLAIN, 18));
            String finalScoreText = "Final Score: " + score;
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(finalScoreText)) / 2;
            g2d.drawString(finalScoreText, x, y_pos + 35);
            
            String highScoreText = "High Score: " + highScore;
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(highScoreText)) / 2;
            g2d.drawString(highScoreText, x, y_pos + 60);

            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            String restartText = "Press SPACE to Restart";
            fm = g2d.getFontMetrics();
            x = (WIDTH - fm.stringWidth(restartText)) / 2;
            g2d.drawString(restartText, x, y_pos + 90);
        }

        // Draw instructions when game just starts
        if (score == 0 && !gameOver && !paused) {
            g2d.setColor(new Color(255, 255, 255, 150));
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
            g2d.drawString("Arrow Keys: Move | P: Pause", 10, 20);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Handle pause
        if (key == KeyEvent.VK_P && !gameOver) {
            paused = !paused;
        }

        // Handle direction keys
        if ((key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) ||
            (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) ||
            (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) ||
            (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)) {
            nextDirection = key;
        }

        // Restart game on SPACE
        if (key == KeyEvent.VK_SPACE && gameOver) {
            restartGame();
        }
    }

    private void restartGame() {
        snake.clear();
        snake.add(new Point(TILES_X / 2, TILES_Y / 2));
        snake.add(new Point(TILES_X / 2 - 1, TILES_Y / 2));
        snake.add(new Point(TILES_X / 2 - 2, TILES_Y / 2));
        direction = KeyEvent.VK_RIGHT;
        nextDirection = KeyEvent.VK_RIGHT;
        score = 0;
        foodEaten = 0;
        shouldGrow = false;
        paused = false;
        gameOver = false;
        spawnFood();
        gameTimer.setDelay(INITIAL_DELAY);
        gameTimer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
