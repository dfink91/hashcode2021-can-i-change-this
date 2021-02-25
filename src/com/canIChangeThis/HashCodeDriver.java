package com.canIChangeThis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class HashCodeDriver {

    public long timeOfSimulation;
    public long qtyIntersections;
    public long qtyStreets;
    public long qtyCars;
    public long qtyPoints;
    public ArrayList<Street> streets;
    public HashMap<Long, Intersection> intersections;

    public String[] run(String[] inputLines) {
        stofacaaazzze(inputLines);
        runImpl();
        return inputLines;
    }

    protected abstract void runImpl();

    public void stofacaaazzze(String[] inputLines) {
        int lineIdx = 0;
        String firstLine = inputLines[lineIdx++];
        Long[] firstLineDetails = Arrays.stream(firstLine.split(" ")).map(Long::valueOf).toArray(Long[]::new);
        timeOfSimulation = firstLineDetails[0];
        qtyIntersections = firstLineDetails[1];
        qtyStreets = firstLineDetails[2];
        qtyCars = firstLineDetails[3];
        qtyPoints = firstLineDetails[4];

        streets = new ArrayList<>();
        intersections = new HashMap<>();
        for (int i = 0; i < qtyStreets; i++) {
            String line = inputLines[lineIdx + i];
            String[] details = line.split(" ");
            long start = Long.parseLong(details[0]);
            long end = Long.parseLong(details[1]);
            Street s = new Street(details[2], start, end, Long.parseLong(details[3]));
            streets.add(s);
            Intersection i1 = intersections.get(start);
            if (i1 == null) {
                i1 = new Intersection(start);
                intersections.put(start, i1);
            }
            i1.addOutStreet(s);

            Intersection i2 = intersections.get(end);
            if (i2 == null)
                i2 = new Intersection(end);
                intersections.put(end, i2);
            i2.addInStreet(s);

        }
    }
}
