package com.canIChangeThis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class FirstSimpleDriver extends HashCodeDriver {

    @Override
    protected String[] runImpl() {
        ArrayList<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
        ArrayList<String> outputLines = new ArrayList<>();
        long cntIntersections = 0;
        ArrayList<String> tmpLines = new ArrayList<>();
        for(int i = 0; i < intersections.size(); i++) {
            Intersection intersection = intersections.get(i);
            ArrayList<String> tmpLight = new ArrayList<>();
            ArrayList<Street> sorted = (ArrayList<Street>)intersection.in.clone();
            sorted.sort((s1, s2) -> s2.count - s1.count); // Absteigend sortieren
            int mittel = 0;
            for(int j = 0; j < sorted.size(); j++) {
                Street s = sorted.get(j);
                mittel += s.count;
            }
            mittel = (mittel / sorted.size()) + 1;

            for(int j = 0; j < sorted.size(); j++) {
                Street s = sorted.get(j);
                if (s.count > 0) {
                    int c = s.count / mittel;
                    if (c == 0)
                        c = 1;
                    tmpLight.add(s.name + " " + c);
                }
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
