package br.com.vitor.model;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    private List<Package> packages;

    private Random rn;

    public Data(Data data){
        packages = new ArrayList<>();

        for(Package p: data.getPackages()){
            Package newPackage = new Package(p.getSize());

            this.packages.add(newPackage);
        }
    }

    public Data() {
        packages = new ArrayList<>();

        rn = new Random();
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void generateRandomData(){
        int numberOfPackages = rn.nextInt(100);

        for (int i = 0; i < numberOfPackages; i++){
            Package pkg = new Package();
            pkg.generateRandomSize(rn);

            packages.add(pkg);
        }
    }

}
