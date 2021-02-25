package com.canIChangeThis;

public class Street {

    public String name;
    public long startIntersection;
    public long endIntersection;
    public long secondsToEnd_L;
    public int count;
    public int countIfInTime;
    public int reihenfolge;

    public Street(String name, long startIntersection, long endIntersection, long secondsToEnd) {
        this.name = name;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.secondsToEnd_L = secondsToEnd_L;
        this.count = 0;
        this.countIfInTime = 0;
        this.reihenfolge = -1;
    }
}
