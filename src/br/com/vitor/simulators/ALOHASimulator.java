package br.com.vitor.simulators;

import br.com.vitor.model.Data;

public class ALOHASimulator {
    private static final float TIME_TO_TRY_AGAIN = 1;

    public static float simulate(int bandwidth, Data data){
        float time = 0;

        while(data.getPackages().size() > 1){
            int size = data.getPackages().get(0).getSize();
            data.getPackages().remove(0);

            float calculatedTime = ((float)size)/bandwidth;
            time += (float) Math.ceil((double) calculatedTime);
        }

        int size = data.getPackages().get(0).getSize();
        data.getPackages().remove(0);

        time += ((float)size)/bandwidth;

        return time;
    }
}
