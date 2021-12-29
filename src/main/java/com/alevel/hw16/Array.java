package com.alevel.hw16;

import java.util.Iterator;

public class Array implements Iterator<Integer> {

    Integer[] mass;
    int current;

    Array(Integer[] mass) {
        this.mass = mass;
        this.current = 0;
    }


    @Override
    public boolean hasNext() {
        return current < mass.length;
    }

    @Override
    public Integer next() {
        return mass[current++];
    }
}
