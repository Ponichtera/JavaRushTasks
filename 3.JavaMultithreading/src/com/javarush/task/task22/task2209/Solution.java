package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...

        try (
                BufferedReader filePathReader = new BufferedReader( new InputStreamReader(System.in));
                BufferedReader reader         = new BufferedReader( new FileReader(filePathReader.readLine()))
                ) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) sb = sb.append(reader.readLine());
            String[] words = sb.toString().split(" ");



            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {e.printStackTrace();}

    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        Collections.sort(list);
        while (list.remove("")){
            list.remove("");
        }
        String first = list.get(0);
        char lastChar = first.toLowerCase().charAt(first.length()-1);
        result.append(first).append(" ");
        list.remove(0);

        while (list.size() > 0) {

            for (String element : list) {
                if (element.toLowerCase().charAt(0) == lastChar) {
                    result.append(element).append(" ");
                    lastChar = element.toLowerCase().charAt(element.length() - 1);
                    list.remove(element);
                    break;
                }
            }
        }
        return result;
    }
}
