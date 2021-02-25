package com.canIChangeThis;

import java.util.ArrayList;

public class FirstSimpleDriver extends HashCodeDriver {

    @Override
    protected String[] runImpl() {
        ArrayList<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
        ArrayList<String> outputLines = new ArrayList<>();
        outputLines.add(intersections.size() + "");
        for(int i = 0; i < intersections.size(); i++) {
            Intersection intersection = intersections.get(i);
            outputLines.add(intersection.id + "");
            outputLines.add(intersection.in.size() + "");
            for(int j = 0; j < intersection.in.size(); j++) {
                Street s = intersection.in.get(j);
                outputLines.add(s.name + " " + s.count);
            }
        }
        return outputLines.toArray(String[]::new);
    }
}
