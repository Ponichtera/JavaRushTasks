package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader breader = new BufferedReader( new InputStreamReader( System.in));
        String file1 = breader.readLine();
        breader.close();

        FileReader reader = new FileReader(file1);

        String s = null;
        int data ;
        while (reader.ready()) {
            if (s == null) s = String.valueOf((char) reader.read());
            data = reader.read();
            if (data == -1) break;
            s += (char) data;
        }

        String[] table = s.split( "[^a-zA-Z]");
        int index = 0;
        for(String entry : table) if (entry.equals("world")) index++;


       // System.out.print(s);
        reader.close();
        System.out.print(index);
    }
}