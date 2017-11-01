package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Object value, int a) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c, int d) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c+d);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c, int d, int e) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c+d+e);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c, int d, int e, int f) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c+d+e+f);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c, int d, int e, int f, int g) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c+d+e+f+g);
        }
    }
    public static void printMatrix(int m, int n, Object value, int a, int b, int c, int d, int e, int f, int g, int h) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println(a+b+c+d+e+f+g + h);
        }
    }
}
