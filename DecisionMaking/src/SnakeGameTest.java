import java.awt.*;
import java.util.*;

/**
 * Unit tests to verify Snake game collision and boundary detection works correctly
 */
public class SnakeGameTest {
    
    static class TestSnake {
        ArrayList<Point> snake = new ArrayList<>();
        private static final int TILES_X = 20;
        private static final int TILES_Y = 20;
        
        TestSnake() {
            snake.add(new Point(10, 10)); // Head
            snake.add(new Point(9, 10));
            snake.add(new Point(8, 10));
        }
        
        // Test boundary collision
        boolean checkWallCollision(Point head) {
            return head.x < 0 || head.x >= TILES_X || head.y < 0 || head.y >= TILES_Y;
        }
        
        // Test self collision
        boolean checkSelfCollision(Point head) {
            for (int i = 1; i < snake.size(); i++) {
                if (head.equals(snake.get(i))) {
                    return true;
                }
            }
            return false;
        }
        
        // Simulate growing snake (eating food)
        void grow(Point newHead) {
            snake.add(0, newHead);
            // Don't remove tail - this simulates eating food
        }
        
        void move(Point newHead) {
            snake.add(0, newHead);
            snake.remove(snake.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Snake Game Collision Detection Tests ===\n");
        
        // Test 1: Wall collision - left boundary
        TestSnake test1 = new TestSnake();
        Point leftWall = new Point(-1, 10);
        boolean result1 = test1.checkWallCollision(leftWall);
        System.out.println("Test 1: Left wall collision (-1, 10): " + (result1 ? "PASS" : "FAIL"));
        
        // Test 2: Wall collision - right boundary
        TestSnake test2 = new TestSnake();
        Point rightWall = new Point(20, 10);
        boolean result2 = test2.checkWallCollision(rightWall);
        System.out.println("Test 2: Right wall collision (20, 10): " + (result2 ? "PASS" : "FAIL"));
        
        // Test 3: Wall collision - top boundary
        TestSnake test3 = new TestSnake();
        Point topWall = new Point(10, -1);
        boolean result3 = test3.checkWallCollision(topWall);
        System.out.println("Test 3: Top wall collision (10, -1): " + (result3 ? "PASS" : "FAIL"));
        
        // Test 4: Wall collision - bottom boundary
        TestSnake test4 = new TestSnake();
        Point bottomWall = new Point(10, 20);
        boolean result4 = test4.checkWallCollision(bottomWall);
        System.out.println("Test 4: Bottom wall collision (10, 20): " + (result4 ? "PASS" : "FAIL"));
        
        // Test 5: Valid position (not collision)
        TestSnake test5 = new TestSnake();
        Point validPos = new Point(15, 15);
        boolean result5 = test5.checkWallCollision(validPos);
        System.out.println("Test 5: Valid position (15, 15): " + (!result5 ? "PASS" : "FAIL"));
        
        // Test 6: Self collision - head touches body segment
        TestSnake test6 = new TestSnake();
        Point selfCollide = new Point(9, 10); // Position of first body segment
        boolean result6 = test6.checkSelfCollision(selfCollide);
        System.out.println("Test 6: Self collision (9, 10): " + (result6 ? "PASS" : "FAIL"));
        
        // Test 7: No self collision - head in empty space
        TestSnake test7 = new TestSnake();
        Point noCollide = new Point(11, 10);
        boolean result7 = test7.checkSelfCollision(noCollide);
        System.out.println("Test 7: No collision (11, 10): " + (!result7 ? "PASS" : "FAIL"));
        
        // Test 8: Snake growth when eating food
        TestSnake test8 = new TestSnake();
        int initialSize = test8.snake.size();
        test8.grow(new Point(11, 10));
        int afterGrow = test8.snake.size();
        System.out.println("Test 8: Snake grows on food: " + (afterGrow == initialSize + 1 ? "PASS" : "FAIL"));
        
        // Test 9: Snake moves without growing
        TestSnake test9 = new TestSnake();
        int sizeBeforeMove = test9.snake.size();
        test9.move(new Point(11, 10));
        int sizeAfterMove = test9.snake.size();
        System.out.println("Test 9: Snake size unchanged on move: " + (sizeBeforeMove == sizeAfterMove ? "PASS" : "FAIL"));
        
        // Test 10: Self collision after growth
        TestSnake test10 = new TestSnake();
        // Simulate snake growing and then checking collision
        test10.grow(new Point(11, 10)); // After eating food, snake becomes [(11,10), (10,10), (9,10), (8,10)]
        // Now if head tries to go to (9,10) (body position), it should collide
        Point growthCollide = new Point(9, 10);
        boolean result10 = test10.checkSelfCollision(growthCollide.equals(test10.snake.get(0)) ? 
            new Point(9, 10) : growthCollide);
        System.out.println("Test 10: Self collision after growth: " + 
            (test10.checkSelfCollision(new Point(9, 10)) ? "PASS" : "FAIL"));
        
        System.out.println("\n=== All tests completed ===");
    }
}
