package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        String[] parString = reader.readLine().split("[?]")[1].split("[&]");
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        for(String partPar : parString){
            String[] par = partPar.split("[=]");
            keys.add(par[0]);
            if(par[0].equals("obj")) values.add(par[1]);
        }
        int i = 0;
        for(String theKey : keys){
            System.out.print(theKey);
            if(i < keys.size() - 1) System.out.print(" ");
            i++;
        }
        System.out.println();
        for(String theValue : values){
            try{
                alert(Double.parseDouble(theValue));
            } catch (Exception e){
                alert(theValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
