package com.canIChangeThis;

import java.util.ArrayList;
import java.util.Comparator;

public class FileDDriver extends HashCodeDriver {

    @Override
    protected String[] runImpl() {
        ArrayList<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
        ArrayList<String> outputLines = new ArrayList<>();
        long cntIntersections = 0;
        ArrayList<String> tmpLines = new ArrayList<>();

        int reihenfolge = 0;
        for (int k = 0; k < maxQtyStreetsPerCar; k++) {
            for (int j = 0; j < qtyCars; j++) {
                Car c = cars.get(j);
                if (c.streets.size() > k) {
                    Street s = c.streets.get(k);
                    if (s.reihenfolge == -1)
                        s.reihenfolge = reihenfolge++;
                }
            }
        }

        for(int i = 0; i < intersections.size(); i++) {
            Intersection intersection = intersections.get(i);
            ArrayList<String> tmpLight = new ArrayList<>();

            ArrayList<Street> orderedIncoming = sortStreets(intersection.in);
            for(int j = 0; j < orderedIncoming.size(); j++) {
                Street s = orderedIncoming.get(j);
                if (s.count > 0)
                    tmpLight.add(s.name + " " + s.count/2 + s.count%2);
            }
            if (tmpLight.size() > 0) {
                cntIntersections++;
                tmpLines.add(intersection.id + "");
                tmpLines.add(tmpLight.size() + "");
                tmpLines.addAll(tmpLight);
            }
        }
        outputLines.add(cntIntersections + "");
        outputLines.addAll(tmpLines);

        return outputLines.toArray(String[]::new);
    }

    private ArrayList<Street> sortStreets(ArrayList<Street> incoming) {
        ArrayList<Street> sorted = (ArrayList<Street>) incoming.clone();
        sorted.sort(Comparator.comparingInt(s -> s.reihenfolge));
        return sorted;
    }
}
