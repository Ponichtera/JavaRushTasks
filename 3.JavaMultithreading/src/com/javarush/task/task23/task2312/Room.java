package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;

/**
 * The main class of the program.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * The main program cycle.
     * All important actions take place here
     */
    public void run() {
        // Create the object "the observer for the keyboard" and start it.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();


        while (snake.isAlive()) {
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                // If equal to the character 'q' - exit the game.
                if (event.getKeyChar() == 'q') return;

                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();
            print();
            sleep();
        }

        System.out.println("Game Over!");
    }

    /**
     * Display the current state of the game
     */
    public void print() {
        // Create an array where we will "draw" the current state of the game
        // Draw all the pieces of the snake
        // Draw the mouse
        // Display all this on the screen
    }

    /**
     * The method is called when the mouse is eaten
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Creates a new mouse
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * The program pauses, the length of which depends on the length of the snake.
     */
    public void sleep() {
      try {
          if (game.snake.getSections().size() < 16 ) Thread.sleep(500 - (20 * (game.snake.getSections().size()-1)));
          else Thread.sleep(200);
      } catch (InterruptedException e) {e.printStackTrace();}
    }
}
