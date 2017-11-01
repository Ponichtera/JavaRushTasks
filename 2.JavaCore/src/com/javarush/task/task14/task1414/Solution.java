package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        ArrayList<Movie> moviesList = new ArrayList<>();

        while ( true ) {
            key = reader.readLine();
            if ( !key.equals("cartoon") && !key.equals("thriller") && !key.equals("soapOpera") ) {
                moviesList.add(Solution.MovieFactory.getMovie(key));
                break;
            }
            else {
                if (key.equals("cartoon")) moviesList.add(Solution.MovieFactory.getMovie(key));
                if (key.equals("thriller")) moviesList.add(Solution.MovieFactory.getMovie(key));
                if (key.equals("soapOpera")) moviesList.add(Solution.MovieFactory.getMovie(key));
            }
        }
        for (Movie movie : moviesList )
        System.out.println( movie.getClass().getSimpleName() );
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            //System.out.print(key);
            Movie movie =  new Movie() {};

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            //System.out.print(movie);

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
