package com.javarush.task.task24.task2411;

import static com.javarush.task.task24.task2411.JustAnInterface.B;

public class C {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}