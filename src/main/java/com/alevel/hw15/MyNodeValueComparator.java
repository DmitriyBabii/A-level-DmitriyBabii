package com.alevel.hw15;

import java.util.Comparator;

class MyNodeValueComparator implements Comparator<MyNode<? extends Number>> {
    @Override
    public int compare(MyNode<? extends Number> o1, MyNode<? extends Number> o2) {
        return (int) o1.getValue() - (int) o2.getValue();
    }
}
