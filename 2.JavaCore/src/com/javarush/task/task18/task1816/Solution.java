package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        try {
            FileInputStream in = new FileInputStream(args[0]);
            long counter = 0;
            while (in.available() > 0) {
                char c = (char)in.read();
                if ( c >='a' && c <= 'z') counter++;
                if ( c >='A' && c <= 'Z') counter++;

            }
            System.out.println(counter);
            in.close();
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }
}
