package com.canIChangeThis;

import java.util.ArrayList;

public class Car {
    public long startIntersection;
    public ArrayList<Street> streets;


    public Car(long start) {
        startIntersection = start;
        streets = new ArrayList<>();
    }

}