package com.alevel.hw14;

public interface Multiplier<T> {
    <T extends Number>T[] doubleValueIn(T[] array);
}
