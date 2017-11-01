package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private Solution(int priv) {}
    public Solution(short pub) {}
    Solution(double w) {}
    protected Solution() {}
    public static void main(String[] args) {

    }
}

