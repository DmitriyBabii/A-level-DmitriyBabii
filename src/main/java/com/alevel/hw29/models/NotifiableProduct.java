package com.alevel.hw29.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class NotifiableProduct extends Product
        implements ProductGenerateAddress {
    @Setter(value = AccessLevel.NONE)
    private static final String type = "NotifiableProduct";
    protected String channel;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String generateAddressForNotification() {
        return "somerandommail@gmail.com";
    }

    @Override
    public String getBasicInfo() {
        return "NotifiableProduct{" +
                "channel='" + channel + '\'' +
                ", id=" + id +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public String toString() {
        return "NotifiableProduct(" +
                "channel='" + channel + '\'' +
                ')';
    }
}