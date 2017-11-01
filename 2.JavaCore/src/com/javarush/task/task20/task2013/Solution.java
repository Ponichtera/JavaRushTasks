package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person() {}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) {
        /*
        Person father = new Person("F", "F",30);
        Person mother = new Person("M", "M",30);
        Person son = new Person("s", "s",10);
        son.setFather(father);
        son.setMother(mother);

        try {
            File file = File.createTempFile("tmp", null);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(son);

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Person f2 = (Person) in.readObject();
            Person m2 = (Person) in.readObject();
            Person s2 = (Person) in.readObject();
            System.out.println(father.children);
            System.out.println(f2.children);
            System.out.println(father.equals(f2));
            System.out.println(father.equals(m2));
            System.out.println(father.equals(s2));

        } catch (IOException e ) {e.printStackTrace();}
        catch (ClassNotFoundException e ){e.printStackTrace();}

*/

    }
}
