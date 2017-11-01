package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader breader = new BufferedReader( new InputStreamReader( System.in));
        String file1 = breader.readLine();
        String file2= breader.readLine();
        breader.close();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        int i=0;
        while (reader.ready()) {
            int data = reader.read();
            i++;
            if (i % 2 == 0)
                writer.write(data);
        }
        reader.close();
        writer.close();
        }
}
