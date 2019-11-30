package br.com.vitor.model;

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
        int packageSize = rn.nextInt(50000000) + 10000000;

        this.setSize(packageSize);
    }
}
