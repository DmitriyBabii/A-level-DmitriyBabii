package com.alevel.hw14;

import java.util.List;

class Util<T> implements Multiplier<T> {
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
    public <E extends Number> E[] doubleValueIn(E[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (E) Double.valueOf(array[i].doubleValue() * array[i].doubleValue());
        }
        return array;
    }

    public <E extends Number> void sum(E one, E two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public <E extends Number> double sumOfArray(List<E> list) {
        double s = 0.0;
        for (E n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public <E extends Number> void addNumbers(List<E> list) {
        for (int i = 1; i <= 10; i++) {
            list.add((E) Double.valueOf(i));
        }
    }
}

