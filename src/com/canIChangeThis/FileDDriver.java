package com.canIChangeThis;

import java.util.ArrayList;

public class FileDDriver extends HashCodeDriver {

    @Override
    protected String[] runImpl() {
        ArrayList<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
        ArrayList<String> outputLines = new ArrayList<>();
        long cntIntersections = 0;
        ArrayList<String> tmpLines = new ArrayList<>();
        for(int i = 0; i < intersections.size(); i++) {
            Intersection intersection = intersections.get(i);
            ArrayList<String> tmpLight = new ArrayList<>();

            for (int k = 0; k < maxQtyStreetsPerCar; k++) {
                for (int j = 0; j < qtyCars; j++) {
                    Car c = cars.get(j);
                    if (c.streets.size() > k) {
                        Street s = c.streets.get(k);
                    }
                }
            }


            for(int j = 0; j < intersection.in.size(); j++) {
                Street s = intersection.in.get(j);
                if (s.count > 0)
                    tmpLight.add(s.name + " " + s.count);
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
}
