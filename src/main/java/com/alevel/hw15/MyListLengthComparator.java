package com.alevel.hw15;

import java.util.Comparator;

public class MyListLengthComparator implements Comparator<MyList<?>> {


    @Override
    public int compare(MyList<?> o1, MyList<?> o2) {
        return o1.getLength() - o2.getLength();
    }
}
