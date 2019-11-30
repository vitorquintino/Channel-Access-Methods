package br.com.vitor.simulators;

import br.com.vitor.model.Data;
import br.com.vitor.model.Package;

import java.util.ArrayList;

public class FDMASimulator {

    private static final int NUMBER_OF_CHANNELS = 10;
    private static final ArrayList<Package> channels = new ArrayList<>();

    public static float simulate(int bandwidth, Data data){
        float time = 0;

        assignFirstPackagesToChannels(data);

        while(channels.size() > 0){
            int smallerPackageIndex = findSmallerPackageIndex();
            int smallerPackageSize = channels.get(smallerPackageIndex).getSize();

            decreaseSmallerSizeOfAllChannels(smallerPackageSize);
            removeSmallerFrommChannel(smallerPackageIndex);

            if(data.getPackages().size() > 0)
                addNextPackageToChannel(data);

            time += ((float)smallerPackageSize/(bandwidth/10.0));
        }

        return time;
    }

    private static void assignFirstPackagesToChannels(Data data){
        ArrayList<Package> packages = (ArrayList<Package>) data.getPackages();

        int stopCondition;
        if(packages.size() < NUMBER_OF_CHANNELS)
            stopCondition = packages.size();
        else
            stopCondition = NUMBER_OF_CHANNELS;


        for(int i = 0; i < stopCondition; i++){
            if(packages.size() > 0){
                channels.add(new Package(packages.get(0).getSize()));

                packages.remove(0);
            }
        }
    }

    private static int findSmallerPackageIndex() {
        int returnValue = 0, smallerValue = 100000000;

        for (int i = 0; i < channels.size(); i++) {
            if(channels.get(i).getSize() < smallerValue){
                returnValue = i;
                smallerValue = channels.get(i).getSize();
            }
        }

        return returnValue;
    }

    private static void decreaseSmallerSizeOfAllChannels(int size) {
        for(int i = 0; i < channels.size(); i++){
            channels.get(i).setSize(channels.get(i).getSize() - size);
        }
    }

    private static void removeSmallerFrommChannel(int smallerPackageIndex) {
        channels.remove(smallerPackageIndex);
    }

    private static void addNextPackageToChannel(Data data) {
        channels.add(data.getPackages().get(0));
        data.getPackages().remove(0);
    }

    private static void printChannel(){
        int i = 1;
        for (Package p: channels) {
            System.out.println("Channel package " + i + ": " + p.getSize() + " bytes.");
            i++;
        }
    }
}
