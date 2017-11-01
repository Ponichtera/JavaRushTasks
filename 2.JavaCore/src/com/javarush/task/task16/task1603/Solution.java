package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        Thread Sp1 = new Thread(new SpecialThread());
        Thread Sp2 = new Thread(new SpecialThread());
        Thread Sp3 = new Thread(new SpecialThread());
        Thread Sp4 = new Thread(new SpecialThread());
        Thread Sp5 = new Thread(new SpecialThread());


        list.add(Sp1);
        list.add(Sp2);
        list.add(Sp3);
        list.add(Sp4);
        list.add(Sp5);


    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
