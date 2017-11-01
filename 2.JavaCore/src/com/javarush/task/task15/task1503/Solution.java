package com.javarush.task.task15.task1503;

/* 
ООП - машинки
*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }

    public static class Ferrari extends LuxuriousCar{
        public void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.FERRARI_NAME);
        }
    }

    public static class Lanos extends CheapCar{
       public void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.LANOS_NAME);
        }
    }
     static class CheapCar {
         void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.CHEAP_CAR);
        }
    }
     static class LuxuriousCar {
         void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.LUXURIOUS_CAR);
        }
    }

     static class Constants {
         static String WANT_STRING = "Я хочу ездить на ";
         static String LUXURIOUS_CAR = "роскошной машине";
         static String CHEAP_CAR = "дешевой машине";
         static String FERRARI_NAME = "Феррари";
         static String LANOS_NAME = "Ланосе";
    }
}
