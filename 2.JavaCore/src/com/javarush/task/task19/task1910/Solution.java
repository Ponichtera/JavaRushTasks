package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader   = new BufferedReader( new InputStreamReader( System.in));
        String in = reader.readLine();
        String out = reader.readLine();

        BufferedReader input    = new BufferedReader( new FileReader(in));
        BufferedWriter output   = new BufferedWriter( new FileWriter(out));
        reader.close();

        while (input.ready()) {
            String data = input.readLine();
            output.write(data.replaceAll("[\\p{Punct}]", ""));
        }
        input.close();
        output.close();
    }
}
