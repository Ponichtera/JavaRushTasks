package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
static
    {
        readKeyFromConsoleAndInitPlanet();
        //System.out.print(thePlanet);
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try{
          // while (true) {
               String s = reader.readLine();
               if (s.equals(Planet.SUN)) Solution.thePlanet = Sun.getInstance ();
               else if (s.equals(Planet.MOON)) Solution.thePlanet = Moon.getInstance ();
               else if (s.equals(Planet.EARTH)) Solution.thePlanet = Earth.getInstance ();
               else Solution.thePlanet = null;
               //System.out.print(thePlanet);
           //}
       } catch (IOException e) {}
    }
}
