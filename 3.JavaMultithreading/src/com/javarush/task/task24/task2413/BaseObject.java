package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    private double x, y, radius;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public abstract void move();
    public abstract void draw(Canvas canvas);
    boolean isIntersec (BaseObject o ){
        double dx = Math.abs(this.getX()-o.getX());
        double dy = Math.abs(this.getY()-o.getY());

        return Math.sqrt(dx*dx+dy*dy) <= Math.max(this.getRadius(), o.getRadius());}
}
