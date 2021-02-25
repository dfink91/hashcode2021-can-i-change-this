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
            ArrayList<String> tmpLight = new ArrayList<>();
            for(int j = 0; j < intersection.in.size(); j++) {
                Street s = intersection.in.get(j);
                if (s.count > 0)
                    tmpLight.add(s.name + " " + s.count);
            }
            if (tmpLight.size() > 0) {
                outputLines.add(intersection.id + "");
                outputLines.add(tmpLight.size() + "");
                outputLines.addAll(tmpLight);
            }
        }
        return outputLines.toArray(String[]::new);
    }

}
