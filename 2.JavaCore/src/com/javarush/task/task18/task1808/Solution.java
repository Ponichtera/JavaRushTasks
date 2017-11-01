package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream data = new FileInputStream(file1);
        FileOutputStream part1 = new FileOutputStream(file2);
        FileOutputStream part2 = new FileOutputStream(file3);

        if (data.available() > 0) {
            int size = data.available() / 2;

            while (data.available() > size) {
                int buffer = data.read();
                part1.write(buffer);
            }
            while (data.available() > 0) {
                int buffer = data.read();
                part2.write(buffer);
            }
        }
            data.close();
            part1.close();
            part2.close();
    }
}
