package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
        String filePatch1 = r.readLine();
        String filePatch2 = r.readLine();

        FileInputStream file1 = new FileInputStream(filePatch1);
        FileOutputStream file2 = new FileOutputStream(filePatch2);
        if (file1.available() > 0) {
            byte[] data = new byte[file1.available()];
           while (file1.available() > 0 ) file1.read(data);
           for ( int i = data.length-1; i >= 0 ; i-- ) file2.write(data[i]);
        }
        file1.close();
        file2.close();
    }
}
