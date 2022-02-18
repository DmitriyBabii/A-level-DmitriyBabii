package com.alevel.hw29;

import com.alevel.hw29.models.Product;
import com.alevel.hw29.utils.ProductUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductUtils utils = new ProductUtils();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            products.add(utils.generateRandomProduct());
        }
        products.forEach(utils::save);

        System.out.println(utils.getAll());
        System.out.println("Notifications sent: " + utils.filterNotifiableProductsAndSendNotifications());
    }
}