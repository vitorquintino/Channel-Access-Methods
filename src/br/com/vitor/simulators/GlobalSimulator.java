package br.com.vitor.simulators;

import br.com.vitor.model.Data;
import br.com.vitor.statistics.Results;

public class GlobalSimulator {
    //Chama cada simulação aqui nesse método
    public static void beginSimulation(int numberOfSimulations){
        int bandwidth = 10000000;

        for (int i = 1; i <= numberOfSimulations; i++) {
            Data data = new Data();
            data.generateRandomData();

            Data fdmaData = new Data(data);
            float fdmaTime = FDMASimulator.simulate(bandwidth, fdmaData);
            System.out.println(fdmaTime);
            Results.addFdmaTime(fdmaTime);

            Data pollingData = new Data(data);
            float pollingTime = PollingSimulator.simulate(bandwidth, pollingData);
            System.out.println(pollingTime);
            Results.addPollingTime(pollingTime);

            Data alohaData = new Data(data);
            float alohaTime = ALOHASimulator.simulate(bandwidth, alohaData);
            System.out.println(alohaTime);
            Results.addAlohaTime(alohaTime);

            Data idealData = new Data(data);
            float idealTime = IdealSimulator.simulate(bandwidth, idealData);
            System.out.println(idealTime);
            Results.addIdealTime(idealTime);

            TDMASimulator.simulate(bandwidth, data);
        }
    }
}
