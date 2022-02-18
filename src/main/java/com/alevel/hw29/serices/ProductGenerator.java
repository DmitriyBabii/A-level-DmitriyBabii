package com.alevel.hw29.serices;

import com.alevel.hw29.models.NotifiableProduct;
import com.alevel.hw29.models.Product;
import com.alevel.hw29.models.ProductBundle;

import java.util.Random;

public class ProductGenerator {
    public static Product generateRandomProduct() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return ProductBundle.builder()
                    .amount(random.nextInt(15))
                    .available(random.nextBoolean())
                    .channel(random.nextBoolean() + "" + random.nextDouble())
                    .price(random.nextDouble())
                    .id(random.nextLong())
                    .title(random.nextFloat() + "" + random.nextDouble())
                    .build();
        } else {
            return NotifiableProduct.builder()
                    .id(random.nextLong())
                    .title(random.nextFloat() + "" + random.nextDouble())
                    .available(random.nextBoolean())
                    .channel(random.nextBoolean() + "" + random.nextDouble())
                    .price(random.nextDouble())
                    .build();
        }
    }
}
