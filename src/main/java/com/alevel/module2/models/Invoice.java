package com.alevel.module2.models;

import lombok.Getter;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
public class Invoice {
    private static int limit;

    private final Date date;
    private final Technics[] technic;
    private final Customer customer;
    private TypeSale type;

    public Invoice(Technics[] technic, Customer customer, Date date) {
        this.technic = technic;
        this.customer = customer;
        this.date = date;
    }

    public int countTelephone() {
        int count = 0;
        for (Technics technics : technic) {
            if (technics.getType().equals("Telephone")) {
                count++;
            }
        }
        return count;
    }

    public int countTelevision() {
        int count = 0;
        for (Technics technics : technic) {
            if (technics.getType().equals("Television")) {
                count++;
            }
        }
        return count;
    }

    public int getCountTechnic() {
        return technic.length;
    }

    public int getPrice() {
        if (sumPrice() > limit) {
            type = TypeSale.WHOLESALE;
        } else {
            type = TypeSale.RETAIL;
        }
        return (int) (sumPrice() * ((type == TypeSale.RETAIL) ? 1.0 : 0.9));
    }

    public TypeSale getType() {
        return type;
    }

    private int sumPrice() {
        return Arrays.stream(technic)
                .mapToInt(Technics::getPrice)
                .sum();
    }

    private String outputTechnic() {
        return Arrays.stream(technic)
                .map(Technics::toString)
                .collect(Collectors.joining(" "));
    }

    public void setType(TypeSale type) {
        this.type = type;
    }

    public static void setLimit(int l) {
        if (limit < 0) throw new IllegalArgumentException("Limit must be more than 0");
        limit = l;
    }

    private String parseDate() {
        String[] date = this.date.toString().split(" ");
        StringBuilder result = new StringBuilder();
        int i;

        try {
            result.append(((i = Integer.parseInt(date[2])) < 10) ? "0" + i : i)
                    .append(".")
                    .append(((i = Month.valueOf(date[1]).number) < 10) ? "0" + i : i)
                    .append(".")
                    .append(date[5])
                    .append(" ");

            date = date[3].split(":");

            result.append(date[0])
                    .append(":")
                    .append(date[1]);
        } catch (NullPointerException e) {
            return this.date.toString();
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "Date: " + parseDate() +
                "\nCustomer:\n" + customer.toString() + "\nOrder:\n" +
                outputTechnic() + "\nPrice = " + getPrice() + "\n" +
                "--------------------------------------------\n";
    }
}
