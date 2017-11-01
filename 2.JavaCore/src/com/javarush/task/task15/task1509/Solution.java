package com.javarush.task.task15.task1509;

/* 
Мужчина или женщина?
*/

public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Human human) {
        if (human instanceof Man) System.out.println(Man.name );
        if (human instanceof Woman) System.out.println(Woman.name );


    }

    public static class Human {
       static  String name = "human";
    }

    public static class Man extends Human {
        static String name = "man";
    }

    public static class Woman extends Human {
        static String name = "woman";
    }
}
