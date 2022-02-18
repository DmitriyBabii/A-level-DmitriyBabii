package com.alevel.hw29.models;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@SuperBuilder
public class ProductBundle extends NotifiableProduct
        implements ProductGetAmount {
    @Setter(value = AccessLevel.NONE)
    private static final String type = "ProductBundle";
    private int amount;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getAmountInBundle() {
        return amount;
    }

    @Override
    public String getBasicInfo() {
        return "ProductBundle{" +
                "channel='" + channel + '\'' +
                ", id=" + id +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", amountInBundle=" + amount +
                '}';
    }

    @Override
    public String toString() {
        return "ProductBundle(" +
                "amount=" + amount +
                ')';
    }
}