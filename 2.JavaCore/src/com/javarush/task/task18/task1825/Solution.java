package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        String fileName = reader.readLine();
        String[] fileNameData = fileName.split("part");
        String outputFilePath = fileNameData[0].substring(0, fileNameData[0].length()-1 );
        HashMap<Integer, byte[]> map = new HashMap<>();
        int parts = 0;
        FileOutputStream out = new FileOutputStream(outputFilePath);

        while (!fileName.equals("end")) {
        FileInputStream input = new FileInputStream(fileName);
        byte[] bytes = new byte[input.available()];
         while (input.available() > 0 ) input.read(bytes);
        map.put(Integer.parseInt(fileName.split("part")[1]), bytes);
        parts++;
         input.close();
         fileName = reader.readLine();
        }

        for (int i = 1; i <= parts; i++) out.write(map.get(i));
        out.close();
        }

    }

