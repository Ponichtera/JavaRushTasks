package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cat дедушка = new Cat(reader.readLine(), null, null);
        Cat бабушка = new Cat(reader.readLine(), null, null)  ;
        Cat папа    = new Cat(reader.readLine(),null, дедушка);
        Cat мама    = new Cat(reader.readLine(),бабушка,null );
        Cat сын     = new Cat(reader.readLine(), мама, папа);
        Cat дочь    = new Cat(reader.readLine(), мама, папа);

        System.out.println(дедушка);
        System.out.println(бабушка);
        System.out.println(папа);
        System.out.println(мама);
        System.out.println(сын);
        System.out.println(дочь);





    }







    public static class Cat {
        private String name;
        private Cat parentMom;
        private Cat parentDad;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMom, Cat parentDad) {
            this.name = name;
            this.parentMom = parentMom;
            this.parentDad = parentDad;
        }

        @Override
        public String toString() {
            if (parentMom == null && parentDad == null)
                return "Cat name is " + name + ", no mother, no  father";
            if (parentDad == null)
                return "Cat name is " + name + ", mother is " + parentMom.name + ", no  father";
            if (parentMom == null)
                return "Cat name is " + name + ", no mother" + ", father is " + parentDad.name;

            else return "Cat name is " + name + ", mother is " + parentMom.name + ", father is " + parentDad.name;
        }
    }

}
