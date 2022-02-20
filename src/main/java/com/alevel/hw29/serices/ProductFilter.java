package com.alevel.hw29.serices;

import com.alevel.hw29.models.NotifiableProduct;
import com.alevel.hw29.models.Product;
import com.alevel.hw29.models.ProductBundle;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public static List<NotifiableProduct> filterNotifiableProducts(List<Product> products) {
        return products.stream().filter(it -> it.getType().equals("NotifiableProduct"))
                .map(it -> (NotifiableProduct) it).collect(Collectors.toList());
    }

    public static List<ProductBundle> filterProductBundles(List<Product> products) {
        return products.stream().filter(it -> it.getType().equals("ProductBundle"))
                .map(it -> (ProductBundle) it).collect(Collectors.toList());
    }
}
