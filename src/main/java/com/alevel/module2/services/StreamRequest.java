package com.alevel.module2.services;

import com.alevel.module2.models.Invoice;
import com.alevel.module2.models.TypeSale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamRequest {

    public int getCountTelephones(ArrayList<Invoice> list) {
        return list.stream().mapToInt(Invoice::countTelephone).sum();
    }

    public int getCountTelevisions(ArrayList<Invoice> list) {
        return list.stream().mapToInt(Invoice::countTelevision).sum();
    }

    public Invoice getSumMinInvoice(ArrayList<Invoice> list) {
        if (list != null) {
            return list.stream().min(Comparator.comparing(Invoice::getPrice)).get();
        }
        return null;
    }

    public int getSumAllInvoices(ArrayList<Invoice> list) {
        return list.stream().mapToInt(Invoice::getPrice).sum();
    }

    public int getCountRetail(ArrayList<Invoice> list) {
        return (int) list.stream().filter(a -> a.getType() == TypeSale.RETAIL).count();
    }

    public int getCountOnlyTypeTechnics(ArrayList<Invoice> list) {
        return (int) list.stream()
                .filter(a -> Arrays.stream(a.getTechnic()).allMatch(b -> b.getType().equals("Telephone")) ||
                        Arrays.stream(a.getTechnic()).allMatch(b -> b.getType().equals("Television")))
                .count();
    }

    public List<Invoice> getOnlyThreeInvoices(ArrayList<Invoice> list) {
        return list.stream().limit(3).collect(Collectors.toList());
    }

    public List<Invoice> getLowAgeInvoices(ArrayList<Invoice> list) {
        return list.stream()
                .filter(a -> a.getCustomer().getAge() < 18)
                .peek(a -> a.setType(TypeSale.LOW_AGE))
                .collect(Collectors.toList());
    }

    public List<Invoice> getSortedInvoices(ArrayList<Invoice> list) {
        Comparator<Invoice> comparator = (o1, o2) -> o2.getCustomer().getAge() - o1.getCustomer().getAge();
        return list.stream()
                .sorted(comparator
                        .thenComparing(Invoice::getCountTechnic)
                        .thenComparing(Invoice::getPrice))
                .collect(Collectors.toList());
    }
}


