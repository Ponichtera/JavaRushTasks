package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import static com.javarush.task.task14.task1408.Country.*;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = new Hen() {
                @Override
                int getCountOfEggsPerMonth() {
                    return 0;
                }
            };
            //напишите тут ваш код
            if (country == BELARUS) hen = new BelarusianHen() ;
            if (country == RUSSIA) hen = new RussianHen() ;
            if (country == MOLDOVA) hen = new MoldovanHen() ;
            if (country == UKRAINE) hen = new UkrainianHen() ;

            return hen;
        }
    }


}
