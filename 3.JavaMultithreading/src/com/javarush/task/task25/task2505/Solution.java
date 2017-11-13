package com.javarush.task.task25.task2505;

import com.sun.javafx.binding.StringFormatter;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }
        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage()));
                e.printStackTrace();
            }
            public MyUncaughtExceptionHandler () {}

        }
        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

