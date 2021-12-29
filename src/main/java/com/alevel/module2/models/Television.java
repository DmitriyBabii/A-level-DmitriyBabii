package com.alevel.module2.models;

public class Television extends Technics {
    private static final String type = "Television";
    private static int count = 0;
    private int diagonal;
    private String country;

    public Television() {
    }

    public Television(String series, int diagonal, Screen screenType, String country, int price) {
        super(series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("series = %-15sscreenType = %-15" +
                "sprice = %-15sdiagonal = %-15" +
                "scountry = %-15s\n", series, screenType, price, diagonal, country);
    }
}
