package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String filePatch = reader.readLine();
//        FileInputStream file = new FileInputStream("D:/data.txt");
        FileInputStream file = new FileInputStream(filePatch);
        int min = 10000;
        while(file.available() > 0) {
            int data =  file.read();
            if (data < min ) min = data;

        }
        file.close();
        System.out.println(min);
    }
}
