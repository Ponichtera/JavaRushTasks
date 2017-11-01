package com.javarush.task.task14.task1408;


import static com.javarush.task.task14.task1408.Country.RUSSIA;

public class RussianHen extends Hen {
    int getCountOfEggsPerMonth() {
        return 2;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}