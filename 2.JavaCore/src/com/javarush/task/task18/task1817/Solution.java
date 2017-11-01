package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        try {
            FileInputStream in = new FileInputStream(args[0]);
            double letters = 0;
            double spaces = 0;

            while (in.available() > 0) {
               char c = (char) in.read();
               letters++;
                if( c == ' ')spaces++;


            }
            System.out.println(String.format("%.2f",(spaces / letters * 100.00)));
            in.close();
        } catch (FileNotFoundException e ) {}
        catch (IOException e) {}

    }
}
