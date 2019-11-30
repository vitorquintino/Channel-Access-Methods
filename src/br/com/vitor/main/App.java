package br.com.vitor.main;

import br.com.vitor.model.Data;
import br.com.vitor.model.Package;
import br.com.vitor.simulators.GlobalSimulator;
import jdk.nashorn.internal.objects.Global;

public class App {

    public static void main(String[] args) {
        int numberOfSimulations = Integer.parseInt(args[0]);

        GlobalSimulator.beginSimulation(numberOfSimulations);
    }

}
