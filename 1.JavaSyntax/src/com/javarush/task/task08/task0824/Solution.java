package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("kid", false, 12);
        Human child2 = new Human("kid2", false, 13);
        Human child3 = new Human("kid3", false, 14);
        Human father = new Human("father", true, 43);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        Human mother = new Human("mother", false, 42);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);
        Human gfather = new Human("granpa", true, 92);
        gfather.children.add(father);
        Human gmather = new Human("grand mam", false, 92);
        gmather.children.add(father);
        Human gfather1 = new Human("grandpa m", true, 92);
        gfather1.children.add(mother);
        Human gmather1 = new Human("grand mam m", false, 92);
        gmather1.children.add(mother);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(gfather);
        System.out.println(gfather1);
        System.out.println(gmather);
        System.out.println(gmather1);
    }

    public static class Human {
        //напишите тут ваш код
        String name = "";
        boolean sex =false;
        int age = -1;
        ArrayList<Human> children = new ArrayList<>();

        Human(String name) {
            this.name = name;
        }

        Human(String name, boolean sex) {
            this(name);
            this.sex = sex;
        }

        Human(String name, boolean sex, int age) {
            this(name, sex);
            this.age = age;
        }

        Human(String name, boolean sex, int age, ArrayList<Human> kids) {
            this(name, sex, age);
            this.children = kids;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
