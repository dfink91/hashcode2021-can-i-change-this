package com.canIChangeThis;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello #code 2021");
        Worker worker = new Worker();
        ArrayList<Worker.FileDriver> fileDrivers = new ArrayList<>();
        fileDrivers.add(new Worker.FileDriver("a", new FileDSimpleDriver()));
        fileDrivers.add(new Worker.FileDriver("b", new FirstSimpleDriver()));
        fileDrivers.add(new Worker.FileDriver("c", new FirstSimpleDriver()));
        fileDrivers.add(new Worker.FileDriver("d", new FileDSimpleDriver()));
        fileDrivers.add(new Worker.FileDriver("e", new FirstSimpleDriver()));
        fileDrivers.add(new Worker.FileDriver("f", new FirstSimpleDriver()));
        worker.fileDrivers = fileDrivers;
        worker.run();
    }
}