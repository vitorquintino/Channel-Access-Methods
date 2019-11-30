package br.com.vitor.statistics;

import java.util.ArrayList;

public class Results {
    private static ArrayList<Float> fdmaTimes = new ArrayList<>();
    private static ArrayList<Float> pollingTimes = new ArrayList<>();
    private static ArrayList<Float> alohaTimes = new ArrayList<>();
    private static ArrayList<Float> idealTimes = new ArrayList<>();

    public static void addFdmaTime(float t){
        fdmaTimes.add(t);
    }

    public static void addPollingTime(float t){
        pollingTimes.add(t);
    }

    public static void addAlohaTime(float t){
        alohaTimes.add(t);
    }

    public static void addIdealTime(float t){
        idealTimes.add(t);
    }
}
