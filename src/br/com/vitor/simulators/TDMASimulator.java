package br.com.vitor.simulators;

import br.com.vitor.model.Data;
import br.com.vitor.model.Package;

public class TDMASimulator {
    public static final int TIME_FRAMES_SIZE = 1;

    public static float simulate(int bandwidth, Data data){
        float time = 0;

        int size = findBiggerPackage(data);
        int auxTime = (int) Math.floor(((double) size)/bandwidth);
        int remainingSize = size - (bandwidth * auxTime);

        int biggerIndex = findBiggerIndex(size, data);
        int check = findLastPackageWithBytesToSend(data, bandwidth * auxTime);

        time += ((float)remainingSize)/bandwidth;
        time += (float) auxTime * data.getPackages().size();

        return time;
    }

    private static int findLastPackageWithBytesToSend(Data data, int value) {
        int i = 0;
        int returnValue = -1;

        for(Package p: data.getPackages()){
            if((p.getSize() - value) > 0)
                returnValue = i;
            i++;
        }
        return returnValue;
    }

    private static int findBiggerIndex(int size, Data data) {
        int i = 0;
        for(Package p: data.getPackages()){
            if(p.getSize() == size)
                return i;
            i++;
        }
        return i;
    }

    private static int findBiggerPackage(Data data) {
        int biggerSize = 0;

        for(Package p: data.getPackages()){
            if(p.getSize() > biggerSize)
                biggerSize = p.getSize();
        }

        return biggerSize;
    }
}
