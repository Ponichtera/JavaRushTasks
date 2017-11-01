package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileOutputStream writer = new FileOutputStream( reader.readLine());

        PrintStream console = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream out     = new PrintStream(array);

        System.setOut(out);
        testString.printSomething();
        System.setOut(console);
        writer.write(array.toByteArray());
        System.out.println(array.toString());

        reader.close();
        writer.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

