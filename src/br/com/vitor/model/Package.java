package br.com.vitor.model;

import br.com.vitor.statistics.Results;

import java.util.Random;

public class Package {

    private int size;

    Package() { }

    public Package(int size){
        this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    void generateRandomSize(Random rn){
        int packageSize = rn.nextInt(90000000) + 10000000;

        this.setSize(packageSize);

        Results.addPackageSize(packageSize);
    }
}
