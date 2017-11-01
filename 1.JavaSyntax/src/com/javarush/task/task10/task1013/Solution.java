package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
       private String name;
        private int age;
        private double height;
        private boolean sex;
        private Human father = null;
        private Human mather = null;

       public Human(String name) {this.name = name;}
        public Human(String name, int age) {this.name = name; this.age = age;}
        public Human(String name, int age, double height) {this.name = name; this.age = age; this.height= height;}
        public Human(String name, int age, double height, boolean sex) {this.name = name; this.age = age; this.height= height; this.sex = sex;}
        public Human(String name, int age, double height, boolean sex, Human father) {this.name = name; this.age = age; this.height= height; this.sex = sex; this.father = father;}
        public Human(String name, int age, double height, boolean sex, Human father, Human mather) {this.name = name; this.age = age; this.height= height; this.sex = sex; this.father = father; this.mather=mather;}
        public Human(String name, boolean sex, Human father, Human mather) {this.name = name;  this.sex = sex; this.father = father; this.mather=mather;}
        public Human(String name, int age, double height,  Human father, Human mather) {this.name = name; this.age = age; this.height= height;  this.father = father; this.mather=mather;}
        public Human(String name, int age,  boolean sex, Human father, Human mather) {this.name = name; this.age = age;  this.sex = sex; this.father = father; this.mather=mather;}
        public Human(String name, double height, boolean sex, Human father, Human mather) {this.name = name;  this.height= height; this.sex = sex; this.father = father; this.mather=mather;}






    }
}
