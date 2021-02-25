package com.canIChangeThis;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class HashCodeDriver {

    public long timeOfSimulation;
    public long qtyIntersections;
    public long qtyStreets;
    public long qtyCars;
    public long qtyPoints;
    public ArrayList<Street> streets;

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
        for (int i = 0; i < qtyStreets; i++) {
            String line = inputLines[lineIdx + i];
            String[] details = line.split(" ");
            streets.add(new Street(details[2], Long.parseLong(details[0]), Long.parseLong(details[1]),
                    Long.parseLong(details[3])));
        }
    }
}
