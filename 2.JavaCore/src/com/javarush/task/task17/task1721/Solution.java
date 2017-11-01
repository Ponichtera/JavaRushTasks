package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        BufferedReader file1In;
        BufferedReader file2In;
        try {
             file1In = new BufferedReader( new InputStreamReader(new FileInputStream( reader.readLine() )));
             file2In = new BufferedReader( new InputStreamReader(new FileInputStream( reader.readLine() )));
            while (file1In.ready()) allLines.add(file1In.readLine());
            while (file2In.ready()) forRemoveLines.add(file2In.readLine());

            file1In.close();
            file2In.close();
            reader.close();
          //  System.out.println(allLines);
           // System.out.println(forRemoveLines);
            new Solution().joinData();
           // System.out.println(allLines);

        } catch (IOException e ) {System.out.print("w ");}




    }

    public void joinData () throws CorruptedDataException {

            if ( allLines.containsAll(forRemoveLines) ) allLines.removeAll(forRemoveLines);
               else { allLines.clear();
                throw new CorruptedDataException(); }
    }
}
