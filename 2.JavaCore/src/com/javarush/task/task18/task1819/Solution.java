package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));

        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();

        FileInputStream fileReader1 = new FileInputStream(filePath1);
        FileInputStream fileReader2 = new FileInputStream(filePath2);


        byte [] buff = new byte[fileReader1.available()];

        while (fileReader1.available() > 0)  fileReader1.read(buff);
           // System.out.print(buff.length);

        FileOutputStream fileWriter = new FileOutputStream(filePath1);
                while (fileReader2.available() > 0) fileWriter.write(fileReader2.read());
                fileWriter.write(buff);

        fileReader1.close();
        fileReader2.close();
        fileWriter.close();
    }
}
