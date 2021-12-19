package com.alevel.hw14;

import java.util.List;

class Util<T> implements Multiplier {
    T value;

    public void printHashCode(T e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public <E extends Number> Number[] doubleValueIn(E[] array) {
        Number[] number = new Number[array.length];
        for (int i = 0; i < array.length; i++) {
            number[i] = array[i].doubleValue() * array[i].doubleValue();
        }
        return number;
    }

    public <E extends Number> void sum(E one, E two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}

