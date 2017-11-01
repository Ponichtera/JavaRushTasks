package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] arr) {

        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if (isNumber(arr[j])) { //Проверяем число ли это
                    for (int k = j + 1; k <= i; k++) { //Цикл для поиска следующего числа в массиве
                        if (isNumber(arr[k])) { //Проверяем элемент является ли он числом
                            if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[k])) { //Если нашли число сравниваем
                                //если первое меньше второго меняем местами
                                String tmp = arr[j];
                                arr[j] = arr[k];
                                arr[k] = tmp;
                            }
                            break; //Останавливаем k цикл, дальще искать нам не надо
                        }
                    }
                }
                else { // это не число, значит это слово. Далле по тому же принципу
                    for (int k = j+1; k <= i; k++) { //Цикл для поиска следующего слова
                        if (!isNumber(arr[k])) { //Проверяем не число ли это
                            if (isGreaterThan(arr[j], arr[k])) {
                                String tmp = arr[j];
                                arr[j] = arr[k];
                                arr[k] = tmp;

                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
