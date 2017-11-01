package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();
        BufferedReader input = new BufferedReader( new InputStreamReader( new FileInputStream(filePath1)));
        BufferedWriter output = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(filePath2)));

        String line= "";
        while (input.ready()) line = input.readLine();
        for (String str : line.split("[ ]")) output.write((int) Math.round(Double.parseDouble(str)) + " ");

        input.close();
        reader.close();
        output.close();
    }
}
