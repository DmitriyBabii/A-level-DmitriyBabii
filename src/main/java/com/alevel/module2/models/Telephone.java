package com.alevel.module2.models;

public class Telephone extends Technics {
    private static final String type = "Telephone";
    public static int count = 0;
    private String model;

    public Telephone() {

    }

    public Telephone(String series, String model, Screen screenType, int price) {
        super(series, screenType, price);
        this.model = model;
        count++;
    }

    public static String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("series = %-15s" +
                "screenType = %-15sprice = %-15s" +
                "model = %-15s\n", series, screenType, price, model);
    }
}
