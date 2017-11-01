package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader   = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader input    = new BufferedReader( new FileReader( reader.readLine()));
        BufferedWriter out      = new BufferedWriter( new FileWriter( reader.readLine()));
        reader.close();
        char data;

        while (input.ready()) {
            data = (char) input.read();
            if (data == '.') data = '!';
            out.write(data);

        }
        input.close();
        out.close();
    }
}
