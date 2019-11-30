package br.com.vitor.statistics;

import java.util.ArrayList;

public class Results {
    private static ArrayList<Float> fdmaTimes = new ArrayList<>();
    private static ArrayList<Float> pollingTimes = new ArrayList<>();

    public static void addFdmaTime(float t){
        fdmaTimes.add(t);
    }

    public static void addPollingTime(float t){
        fdmaTimes.add(t);
    }

}
