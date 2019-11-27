package br.com.vitor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    private List<Package> packages;

    Random rn;

    public Data() {
        packages = new ArrayList<>();

        rn = new Random();
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void generateRandomData(){
        int numberOfPackages = rn.nextInt(90) + 10;

        for (int i = 0; i < numberOfPackages; i++){
            Package pkg = new Package();
            pkg.generateRandomSize(rn);

            packages.add(pkg);
        }
    }

}
