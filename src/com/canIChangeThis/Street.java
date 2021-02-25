package com.canIChangeThis;

public class Street {

    public String name;
    public long startIntersection;
    public long endIntersection;
    public long secondsToEnd_L;

    public Street(String name, long startIntersection, long endIntersection, long secondsToEnd) {
        this.name = name;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.secondsToEnd_L = secondsToEnd_L;
    }
}
