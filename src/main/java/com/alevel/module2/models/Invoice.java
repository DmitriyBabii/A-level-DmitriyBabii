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

    public int countTelephone() {
        int count = 0;
        for (int i = 0; i < technic.length; i++) {
            if (technic[i].getType().equals("Telephone")) {
                count++;
            }
        }
        return count;
    }

    public int countTelevision() {
        int count = 0;
        for (int i = 0; i < technic.length; i++) {
            if (technic[i].getType().equals("Television")) {
                count++;
            }
        }
        return count;
    }

    public int getCountTechnic() {
        return technic.length;
    }

    public int getAge() {
        return customer.getAge();
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

    public void setType(TypeSale type) {
        this.type = type;
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

    public TypeSale getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Customer:\n" + customer.toString() + "\nOrder:\n" +
                outputTechnic() + "\nPrice = " + getPrice() + "\n" +
                "--------------------------------------------\n";
    }
}
