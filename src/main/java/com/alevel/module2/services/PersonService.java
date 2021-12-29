package com.alevel.module2.services;

import com.alevel.module2.models.Customer;

import java.util.Random;

public class PersonService {
    public static Customer generateCustomer() {
        Random rand = new Random();

        StringBuilder email = new StringBuilder();
        int count = 10 + rand.nextInt(11);
        for (int i = 0; i < count; i++) {
            email.append((char) (97 + rand.nextInt(23)));
        }
        email.append("@gmail.com");

        String id = "" + Math.abs(rand.nextLong());

        return new Customer(id, email.toString(), 10 + rand.nextInt(31));
    }
}
