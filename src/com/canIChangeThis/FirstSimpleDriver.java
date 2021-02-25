package com.canIChangeThis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class FirstSimpleDriver extends HashCodeDriver {

    @Override
    protected String[] runImpl() {
        ArrayList<Intersection> intObjects = new ArrayList<>(intersections.values());
        ArrayList<String> outputLines = new ArrayList<>();
        outputLines.add(intObjects.size() + "");
        for(int i = 0; i < intObjects.size(); i++) {
            Intersection intersection = intObjects.get(i);
            outputLines.add(intersection.id + "");
            outputLines.add(intersection.in.size() + "");
            for(int j = 0; j < intersection.in.size(); j++) {
                outputLines.add(intersection.in.get(j).name);
            }
        }
        return outputLines.toArray(String[]::new);
    }
}
