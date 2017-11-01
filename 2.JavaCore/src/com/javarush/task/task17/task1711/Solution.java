package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length == 0) return;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                if ((args.length - 1) % 3 != 0) return;

                for (int i = 0; i < args.length-1 ; i = i +3) {
                    Date birth = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
                    try {
                        birth = sdf.parse(args[3+i]);
                    } catch (ParseException e ) {}

                    if (args[2+i].equals("м")) {
                        allPeople.add(Person.createMale(args[1+i], birth));
                        System.out.println(allPeople.size()-1);
                    }

                    if (args[2+i].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1+i], birth));
                        System.out.println(allPeople.size()-1);
                    }
                    else return;
                }
                break; }
            case "-u":
                synchronized (allPeople) {
                if ((args.length - 1) % 4 != 0) return;

                for (int i = 0; i < args.length-1 ; i = i + 4) {
                    int id = Integer.parseInt(args[1+i]);
                    if (id < 0 || id >= allPeople.size()) return;

                    Person person = allPeople.get(id);
                    person.setName(args[2+i]);
                    if (args[3+i].equals("м")) person.setSex(Sex.MALE);
                    else if (args[3+i].equals("ж")) person.setSex(Sex.FEMALE);
                    else return;

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        person.setBirthDay(sdf.parse(args[4+i])); } catch (ParseException e) {}

                }
                break;}
            case "-d":
                synchronized (allPeople) {
                if (args.length < 2) return;
                for (int i = 1; i < args.length; i++) {
                    int id = Integer.parseInt(args[i]);
                    if (id < 0 || id >= allPeople.size() ) return;
                    Person person = allPeople.get(id);
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }
                break;}

            case "-i":
                synchronized (allPeople) {
                if (args.length < 2) return;
                for (int i = 1; i < args.length; i++) {
                     int id = Integer.parseInt(args[i]);
                     if (id < 0 || id >= allPeople.size() ) return;

                     Person person = allPeople.get(id);
                     String sex = null;
                    if (person.getSex().equals(Sex.MALE)) sex = "м";
                    else if (person.getSex().equals(Sex.FEMALE)) sex = "ж";
                    else return;

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");
                    System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));
                }
            break; }
        }
    }
}
