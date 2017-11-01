package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        Thread t1 = new Thread1();
        threads.add(t1);
        Thread t2 = new Thread2();
        threads.add(t2);
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        Thread t5 = new Thread5();
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);

    }


    public static void main(String[] args) {
       for (Thread t : threads) t.start();

    }

    public static  class Thread1 extends Thread {

        public void run() {
            while (true) {}
        }
    }
    public static class Thread2 extends Thread {

        public void run() {
            try {
                super.run();
               throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
        public static class Thread3 extends Thread {

            public void run() {
                try {
                    while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500); }
                } catch (InterruptedException e) {
                }

            }
        }

        public static class Thread4 extends Thread implements Message {

            public void run() {
                super.run();
            }

            public void showWarning() {
                this.interrupt();
            }
        }

        public static class Thread5 extends Thread {


            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int sum = 0;
                try {
                    String key = reader.readLine();
                    while (true) {
                        if (key.equals("N")) break;
                        sum += Integer.parseInt(key);
                        key = reader.readLine();
                    }
                    System.out.println(sum);
                } catch (IOException e) {
                }
            }
        }

    }