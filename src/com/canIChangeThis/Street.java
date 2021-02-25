package com.canIChangeThis;

public class Street {

    public String name;
    public String startIntersection;
    public String endIntersection;
    public int secondsToEnd;

    public Street(String name, String startIntersection, String endIntersection, int secondsToEnd) {
        this.name = name;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.secondsToEnd = secondsToEnd;
    }
}
