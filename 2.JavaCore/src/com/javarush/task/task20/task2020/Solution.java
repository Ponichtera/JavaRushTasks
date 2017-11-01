package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {
    //public Solution () {} will be automatically created
    public static class Person implements Serializable{
        String firstName;
        String lastName;
       transient String fullName;
       transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception {
        Person man = new Person("first", "last", "USA", Sex.MALE);
        File file = File.createTempFile("tmp", ".bin");
        file.deleteOnExit();
        ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream(file));
        outputStream.writeObject(man);
        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream(file));
        Person loadedPerson = (Person) inputStream.readObject();

    }
}
