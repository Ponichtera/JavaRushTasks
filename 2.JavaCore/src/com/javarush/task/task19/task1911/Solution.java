package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream console = System.out;
            PrintStream print = new PrintStream( outputStream);
            System.setOut(print);
            testString.printSomething();
            String result = outputStream.toString().toUpperCase();
            System.setOut(console);
            System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
