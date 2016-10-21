package com.kepler.brandde.dao;


/**
 * Created by 12 on 9/27/2016.
 */
public class Brand {
    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final String name;
    public int sectionPosition;
    public int listPosition;

    public Brand(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

}
