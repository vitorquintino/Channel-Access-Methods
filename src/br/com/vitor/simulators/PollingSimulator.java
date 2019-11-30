package br.com.vitor.simulators;

import br.com.vitor.model.Data;

public class PollingSimulator {
    public static float simulate(int bandwidth, Data data){
        float time = 0;

        while(data.getPackages().size() > 0){
            int size = get10nextPackagesSizes(data);
            time += ((float)size)/bandwidth;
        }

        return time;
    }

    private static int get10nextPackagesSizes(Data data) {
        int size = 0;
        for(int i = 0; i < 10; i++){
            size += data.getPackages().get(0).getSize();
            data.getPackages().remove(0);
            if(data.getPackages().size() == 0) break;
        }
        return size;
    }
}
