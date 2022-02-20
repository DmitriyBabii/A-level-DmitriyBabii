package com.alevel.hw29.utils;

import com.alevel.hw29.models.Product;
import com.alevel.hw29.repositories.ProductRepository;
import com.alevel.hw29.serices.ProductFilter;
import com.alevel.hw29.serices.ProductGenerator;
import com.alevel.hw29.serices.ProductNotificationSender;

import java.util.List;


public class ProductUtils {
    private final ProductRepository repository = new ProductRepository();

    public void save(Product product) {
        repository.save(product);
    }

    public long filterNotifiableProductsAndSendNotifications() {
        return ProductNotificationSender.sendNotifications(
                ProductFilter.filterNotifiableProducts(repository.getAll())
        );
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Product generateRandomProduct() {
        return ProductGenerator.generateRandomProduct();
    }
}
