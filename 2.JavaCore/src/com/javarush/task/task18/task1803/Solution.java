package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[256];
        for (int i = 0 ; i < array.length ; i++) array[i] = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePatch = reader.readLine();
        FileInputStream file = new FileInputStream(filePatch);

        while (file.available() > 0 ) {
            int data = file.read();
            //System.out.print(data + " ");
            array[data] = array[data] + 1;
        }
        file.close();

        int max= 0;
        for (int i = 0 ; i < array.length ; i++) if (array[i] > max) max = array[i];

        for (int i = 0 ; i < array.length ; i++) if (array[i] == max) System.out.print(i + " ");
           // System.out.print(array[i] + " ");
    }
}
