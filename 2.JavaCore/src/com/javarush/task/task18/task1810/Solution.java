package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
        String inFile = r.readLine();


        while (!inFile.equals("")) {
            FileInputStream in = new FileInputStream(inFile);
            if (in.available() < 1000) {
                in.close();
                throw new DownloadException();

            } else {
                in.close();
                inFile = r.readLine();
            }

        }
            r.close();

    }

    public static class DownloadException extends Exception {

    }
}
