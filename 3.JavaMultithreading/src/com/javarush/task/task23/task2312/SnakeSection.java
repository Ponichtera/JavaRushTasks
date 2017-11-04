package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
       return  31 * x + y;
    }

    @Override
    public boolean equals(Object obj) {
       /* if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof SnakeSection)) return false;*/
        SnakeSection snakeSection = (SnakeSection) obj;
        if (getX() != snakeSection.getX()) return false;

        return getY() == snakeSection.getY();
    }

}
