package com.canIChangeThis;

import java.util.ArrayList;

public class Car {
    public long startIntersection;
    public ArrayList<Street> streets;
    public long totalTripTime;


    public Car(long start) {
        startIntersection = start;
        streets = new ArrayList<>();
        totalTripTime = 0;
    }

    public void calcTotalTripTime() {
        for(Street s: streets) {
            totalTripTime += s.secondsToEnd_L;
        }
    }
}