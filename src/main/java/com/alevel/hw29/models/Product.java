package com.alevel.hw29.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Product
        implements ProductInfo {
    @Setter(value = AccessLevel.NONE)
    private static final String type = "Product";
    protected long id;
    protected boolean available;
    protected String title;
    protected double price;

    public String getType() {
        return type;
    }

    @Override
    public String getBasicInfo() {
        return "Product{" +
                "id=" + id +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}