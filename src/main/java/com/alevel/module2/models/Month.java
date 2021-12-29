package com.alevel.module2.models;

public enum Month {
    Jan(1), Feb(2), Mar(3), Apr(4),
    May(5), June(6), July(7), Aug(8),
    Sep(9), Oct(10), Nov(11), Dec(12);

    public final int number;

    Month(int i) {
        number = i;
    }
}
