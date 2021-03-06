package com.javarush.task.task23.task2312;

import sun.swing.SwingUtilities2;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private boolean isAlive;
    private List<SnakeSection> sections = new ArrayList<>();
    private SnakeDirection direction;

    public boolean isAlive() {
        return isAlive;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake (int x, int y) {
        SnakeSection head = new SnakeSection(x,y);
        sections.add(head);
        isAlive = true;

    }
    public int getX() {
        return sections.get(0).getX();
    }
    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {}
}
