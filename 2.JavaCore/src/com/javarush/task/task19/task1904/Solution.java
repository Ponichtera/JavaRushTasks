package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        String name = "Иванов Иван Иванович 13 09 1993";

        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));

        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read()  {
            String data = fileScanner.nextLine();
            String[] s = data.split(" ");
            String bDate = s[3] + " " + s[4] + " " + s[5];
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy"); // дд мм гггг

            try {
                return new Person(s[1], s[2], s[0], sdf.parse(bDate));
            } catch (ParseException e) { return null; }
    }

        @Override
        public void close() throws IOException {
           fileScanner.close();
        }
    }
    }

