package br.com.vitor.model;

import java.util.Random;

public class Package {

    private int size;

    public Package() { }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void generateRandomSize(Random rn){
        int packageSize = rn.nextInt(30000000) + 10000000;

        this.setSize(packageSize);
    }
}
