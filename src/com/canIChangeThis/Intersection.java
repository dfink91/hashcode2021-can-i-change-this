package com.canIChangeThis;

import java.util.ArrayList;

public class Intersection {

    public long id;
    public ArrayList<Street> in;
    public ArrayList<Street> out;

    public Intersection(long id) {
        this.id = id;
        this.in = new ArrayList<>();
        this.out = new ArrayList<>();
    }

    public void addInStreet(Street s) {
        this.in.add(s);
    }
    public void addOutStreet(Street s) {
        this.in.add(s);
    }

}
