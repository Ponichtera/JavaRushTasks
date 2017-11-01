package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();


    public Hippodrome (List horsesList ) {
        horses = horsesList;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
       try{
           for (int i = 0; i<100 ; i++) {
               this.move();
               this.print();
               Thread.sleep(200);
           }
       } catch (InterruptedException e ) {e.printStackTrace();}
    }
    public void print() {
        for (Horse horse : horses) horse.print();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void move() {
        for (Horse horse : horses) horse.move();
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        double dis = horses.get(0).getDistance();
        for (Horse horse : horses)
            if (horse.getDistance() > dis)
            {
                dis = horse.getDistance();
                winner = horse;
            }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main (String[] args) {
        Horse horse1 = new Horse("first", 0, 0);
        Horse horse2 = new Horse("second", 1, 0);
        Horse horse3 = new Horse("third", 2, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
}
