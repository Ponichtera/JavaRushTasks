package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = File.createTempFile("1txt", "dat");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy");

            User piotr = new User();
                    piotr.setFirstName("Piotr");
                    piotr.setLastName("Piotrowski");
                    piotr.setBirthDate(sdf.parse("25/12/1999"));
                    piotr.setMale(true);
                    piotr.setCountry(User.Country.OTHER);
            javaRush.users.add(piotr);

            User pawel = new User();
                    pawel.setFirstName("Pawel");
                    pawel.setLastName("Pawlowicz");
                    pawel.setBirthDate(sdf.parse("15/12/1999"));
                    pawel.setMale(false);
                    pawel.setCountry(User.Country.OTHER);
            javaRush.users.add(pawel);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User user : loadedObject.users)
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getCountry() + " " + user.getBirthDate());
           System.out.println(javaRush.equals(loadedObject));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter saver = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            for(User user : users) {
                saver.println(user.getFirstName());
                saver.println(user.getLastName());
                saver.println(sdf.format(user.getBirthDate()));
                saver.println(user.isMale());
                saver.println(user.getCountry());
            }
            saver.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader loader = new BufferedReader( new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            String name;
            while ((name = loader.readLine()) != null) {
                User tmpUser = new User();
                tmpUser.setFirstName(name);
                tmpUser.setLastName(loader.readLine());
                tmpUser.setBirthDate(sdf.parse(loader.readLine()));
                tmpUser.setMale(Boolean.parseBoolean(loader.readLine()));
                tmpUser.setCountry(User.Country.valueOf(loader.readLine()));
                users.add((tmpUser));
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
