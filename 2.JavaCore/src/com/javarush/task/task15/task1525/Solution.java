package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Statics.FILE_NAME))));
            String line = reader.readLine();
            while( line != null){
                Solution.lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        }catch(IOException e){e.printStackTrace();}

    }

    public static void main(String[] args) {

        System.out.println(lines);
    }
}
