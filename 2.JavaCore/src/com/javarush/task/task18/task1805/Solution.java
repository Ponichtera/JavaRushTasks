package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

       // byte[] arrBytes = new byte[256];
       // long startTime = System.currentTimeMillis();

        SortedSet<Integer> list = new TreeSet<Integer>();
        while(inputStream.available()>0) list.add(inputStream.read());
        inputStream.close();

        while (!list.isEmpty())        {
            System.out.print(list.first() + " ");
            list.remove(list.first());
        }

    }
}
