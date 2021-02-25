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
    public HashMap<String, Street> streets;
    public HashMap<Long, Intersection> intersectionsMap;

    public String[] run(String[] inputLines) {
        stofacaaazzze(inputLines);
        return runImpl();
    }

    protected abstract String[] runImpl();

    public void stofacaaazzze(String[] inputLines) {
        int lineIdx = 0;
        String firstLine = inputLines[lineIdx++];
        Long[] firstLineDetails = Arrays.stream(firstLine.split(" ")).map(Long::valueOf).toArray(Long[]::new);
        timeOfSimulation = firstLineDetails[0];
        qtyIntersections = firstLineDetails[1];
        qtyStreets = firstLineDetails[2];
        qtyCars = firstLineDetails[3];
        qtyPoints = firstLineDetails[4];

        streets = new HashMap<>();
        intersectionsMap = new HashMap<>();
        for (int i = 0; i < qtyStreets; i++) {
            String line = inputLines[lineIdx + i];
            String[] details = line.split(" ");
            long start = Long.parseLong(details[0]);
            long end = Long.parseLong(details[1]);
            Street s = new Street(details[2], start, end, Long.parseLong(details[3]));
            streets.put(s.name, s);
            Intersection i1 = intersectionsMap.get(start);
            if (i1 == null) {
                i1 = new Intersection(start);
                intersectionsMap.put(start, i1);
            }
            i1.addOutStreet(s);

            Intersection i2 = intersectionsMap.get(end);
            if (i2 == null)
                i2 = new Intersection(end);
                intersectionsMap.put(end, i2);
            i2.addInStreet(s);
        }
        lineIdx += qtyStreets;
        for (int i = 0; i < qtyCars; i++) {
            String line = inputLines[lineIdx + i];
            String[] details = line.split(" ");
            long start = Long.parseLong(details[0]);
            Car c = new Car(start);
            for (int j = 1; j < details.length; j++) {
                Street s = streets.get(details[j]);
                s.count++;
                c.streets.add(s);
            }
            c.calcTotalTripTime();
            for (int j = 1; j < details.length; j++) {
                Street s = streets.get(details[j]);
                c.streets.add(s);
                if (c.totalTripTime < timeOfSimulation/2)
                    s.countIfInTime =+ 1;
            }
        }
    }
}
