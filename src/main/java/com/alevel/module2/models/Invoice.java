package com.alevel.module2.models;

import lombok.Getter;

@Getter
public class Invoice {
    private static int limit;

    private Technics[] technic;
    private Customer customer;
    private TypeSale type;

    public Invoice(Technics[] technic, Customer customer) {
        this.technic = technic;
        this.customer = customer;
    }

    public int getPrice() {
        if (sumPrice() > limit) {
            type = TypeSale.WHOLESALE;
        } else {
            type = TypeSale.RETAIL;
        }
        return (int) (sumPrice() * ((type == TypeSale.RETAIL) ? 1.0 : 0.9));
    }


    public static void setLimit(int l) {
        if (limit < 0) throw new IllegalArgumentException("Limit must be more than 0");
        limit = l;
    }

    private int sumPrice() {
        int sum = 0;
        for (int i = 0; i < technic.length; i++) {
            sum += technic[i].getPrice();
        }
        return sum;
    }

    private String outputTechnic() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < technic.length; i++) {
            str.append(technic[i]);
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Customer:\n" + customer.toString() + "\n\nOrder:\n" +
                outputTechnic() + "\nPrice = " + getPrice() + "\n" +
                "--------------------------------------------\n";
    }
}
