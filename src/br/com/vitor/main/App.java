package br.com.vitor.main;

import br.com.vitor.model.Data;
import br.com.vitor.model.Package;

public class App {

    public static void main(String[] args) {
        Data data = new Data();

        data.generateRandomData();

        int i = 1;
        for (Package p: data.getPackages()){
            System.out.println("Package " + i + ": " + p.getSize() + " bytes.");
            i++;
        }
    }

}
