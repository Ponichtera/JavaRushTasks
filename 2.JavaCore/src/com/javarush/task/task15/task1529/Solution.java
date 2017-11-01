package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
        String key = reader.readLine();
        if ( key.equals("helicopter")) result = new Helicopter();

            if (key.equals("plane")) result = new Plane(Integer.parseInt(reader.readLine()));
            reader.close();
        } catch (IOException e) {}

        //add your code here - добавьте код тут
    }
}
