package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String file1;
        String file2;
        String file3;

        FileWriter f1;
        FileReader f2;
        FileReader f3;

        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();

            f1 = new FileWriter(file1);
            f2 = new FileReader(file2);
            f3 = new FileReader(file3);

            while (f2.ready())
                f1.write(f2.read());
            f2.close();
            while (f3.ready())
                f1.write(f3.read());
            f1.close();
            f3.close();

        } catch (IOException e) {}


    }
}
