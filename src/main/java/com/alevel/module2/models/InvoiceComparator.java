package com.alevel.module2.models;

import java.util.Comparator;

public class InvoiceComparator implements Comparator<Invoice> {
    @Override
    public int compare(Invoice o1, Invoice o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
