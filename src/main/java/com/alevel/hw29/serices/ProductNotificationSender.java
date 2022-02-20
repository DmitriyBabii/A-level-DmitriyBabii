package com.alevel.hw29.serices;

import com.alevel.hw29.models.NotifiableProduct;

import java.util.List;

public class ProductNotificationSender {
    public static long sendNotifications(List<NotifiableProduct> products) {
        products.forEach(it -> System.out.println(it.getChannel()));
        return products.size();
    }
}
