package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args.length < 2 || args.length>5|| args.length==3) {
            return;
        }
        switch(args.length) {
            case 4:
                if(args[0].equals("-c")) {
                    Date birth=null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        birth=sdf.parse(args[3]);
                    }
                    catch (Exception e) {
                    }
                    if(args[2].equals("м")) {
                        allPeople.add(Person.createMale(args[1], birth));
                        System.out.println(allPeople.size()-1);
                    }
                    else if (args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1], birth));
                        System.out.println(allPeople.size()-1);
                    }
                    else return;
                }
                break;
            case 5:
                if(args[0].equals("-u")) {
                    int id = Integer.parseInt(args[1]);
                    if(id < 0 || id >= allPeople.size()) {
                        return;
                    }
                    Person person = allPeople.get(id);
                    person.setName(args[2]);
                    if(args[3].equals("м")) {
                        person.setSex(Sex.MALE);
                    }
                    else if (args[3].equals("ж")) {
                        person.setSex(Sex.FEMALE);
                    }
                    else return;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        person.setBirthDay(sdf.parse(args[4]));
                    }
                    catch (Exception e) {
                    }
                }
                break;
            case 2:
                if(args[0].equals("-d")) {
                    int id = Integer.parseInt(args[1]);
                    if(id < 0 || id >= allPeople.size()) {
                        return;
                    }
                    Person person = allPeople.get(id);
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }
                if(args[0].equals("-i")) {
                    int id = Integer.parseInt(args[1]);
                    if(id < 0 || id >= allPeople.size()) {
                        return;
                    }
                    Person person = allPeople.get(id);
                    String sexStr = null;
                    if(person.getSex().equals(Sex.MALE)) {
                        sexStr="м";
                    }
                    else if(person.getSex().equals(Sex.FEMALE)) {
                        sexStr="ж";
                    }
                    else return;
                    SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-YYYY");
                    System.out.println(person.getName() + " " + sexStr + " " + sdf.format(person.getBirthDay()));
                }
                break;
        }

    }
}