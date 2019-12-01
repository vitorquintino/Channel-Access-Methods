package br.com.vitor.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private static List<Integer> numberOfPackages = new ArrayList<>();
    private static List<Integer> sizeOfPackages = new ArrayList<>();

    private static List<Float> fdmaTimes = new ArrayList<>();
    private static List<Float> pollingTimes = new ArrayList<>();
    private static List<Float> alohaTimes = new ArrayList<>();
    private static List<Float> idealTimes = new ArrayList<>();
    private static List<Float> tdmaTimes = new ArrayList<>();

    private static Map<String, Float> finalResults = new HashMap<>();

    public static void closeResults(){
        calculateFdmaAverage();
        calculateTdmaAverage();
        calculatePollingAverage();
        calculateAlohaAverage();
        calculateIdealAverage();
        calculatePackageQuantityAverage();
        calculatePackageSizeAverage();
    }

    private static void calculatePackageSizeAverage() {
        float total = 0;
        for(int f: sizeOfPackages){
            total += f;
        }
        float average = (float) total/sizeOfPackages.size();

        finalResults.put("Média de tamanho de pacotes: ", average);
    }

    private static void calculatePackageQuantityAverage() {
        float total = 0;
        for(int f: numberOfPackages){
            total += f;
        }
        float average = (float) total/numberOfPackages.size();

        finalResults.put("Média de quantidade de pacotes: ", average);
    }

    private static void calculateIdealAverage() {
        float total = 0;
        for(Float f: idealTimes){
            total += f;
        }
        float average = total/idealTimes.size();

        finalResults.put("Média de tempo do algoritmo ideal: ", average);
    }

    private static void calculateAlohaAverage() {
        float total = 0;
        for(Float f: alohaTimes){
            total += f;
        }
        float average = total/alohaTimes.size();

        finalResults.put("Média de tempo do ALOHA: ", average);
    }

    private static void calculatePollingAverage() {
        float total = 0;
        for(Float f: pollingTimes){
            total += f;
        }
        float average = total/pollingTimes.size();

        finalResults.put("Média de tempo do Polling: ", average);
    }

    private static void calculateTdmaAverage() {
        float total = 0;
        for(Float f: tdmaTimes){
            total += f;
        }
        float average = total/tdmaTimes.size();

        finalResults.put("Média de tempo do TDMA: ", average);
    }

    private static void calculateFdmaAverage() {
        float total = 0;
        for(Float f: fdmaTimes){
            total += f;
        }
        float average = total/fdmaTimes.size();

        finalResults.put("Média de tempo do FDMA: ", average);
    }


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

    public static void addTdmaTime(float t){
        tdmaTimes.add(t);
    }

    public static void addPackageQuantity(int t){
        numberOfPackages.add(t);
    }

    public static void addPackageSize(int t){
        sizeOfPackages.add(t);
    }

    public static void printResults() {
        finalResults.forEach((k, v) -> System.out.println(k + v));
    }
}
