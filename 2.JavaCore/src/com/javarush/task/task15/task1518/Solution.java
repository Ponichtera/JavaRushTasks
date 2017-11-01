package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;
    public static class Cat {
        public String name;
    }
    static {

        Solution.cat = new Cat();
        cat.name = "sfe";
        System.out.print(cat.name);
    }


    public static void main(String[] args) {

    }
}
