package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
         Scanner s = new Scanner(new File(reader.readLine()))) {

         ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext())
            list.add(s.next());

         for (int i = 0; i < list.size()-1; i++) {
             if (list.get(i).equals(new StringBuilder(list.get(i+1)).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(i+1);
                    result.add(pair);
                }
         }
       for(Pair pair : result) System.out.println(pair);

    }catch (Exception e ) {}
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
