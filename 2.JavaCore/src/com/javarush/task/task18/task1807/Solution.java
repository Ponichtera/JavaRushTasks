package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePatch = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filePatch);

        int counter = 0;

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();
            if (readByte == 44) {
                counter++;
            }
        }
        inputStream.close();
        System.out.println(counter);

    }
}
