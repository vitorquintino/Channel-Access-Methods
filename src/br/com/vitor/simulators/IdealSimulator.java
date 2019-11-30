package br.com.vitor.simulators;

import br.com.vitor.model.Data;
import br.com.vitor.model.Package;

public class IdealSimulator {
    public static float simulate(int bandwidth, Data data){
        float time = 0;

        int size = findBiggerPackage(data);
        float bandwidthForBiggerPackage = ((float)bandwidth)/data.getPackages().size();

        time += ((float) size)/bandwidthForBiggerPackage;

        return time;
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
