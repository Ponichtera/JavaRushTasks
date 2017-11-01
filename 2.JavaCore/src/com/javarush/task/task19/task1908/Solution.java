package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader( new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter (new FileWriter(reader.readLine()));
        reader.close();

        String data = "";
        while (fileReader.ready()) {
            data=fileReader.readLine();
        for (String element : data.split(" ")) if (element.matches("\\d+")) fileWriter.write(element+" ");}

        fileReader.close();
        fileWriter.close();
    }
}
