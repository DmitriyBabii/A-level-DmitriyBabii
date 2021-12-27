package com.alevel.module2.models;

import lombok.Getter;

@Getter
abstract public class Technics {
    protected String series;
    protected Screen screenType;
    protected int price;

    public Technics() {
    }

    public Technics(String series, Screen screenType, int price) {
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }

}
