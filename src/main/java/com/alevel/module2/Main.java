package com.alevel.module2;

import com.alevel.module2.models.Invoice;
import com.alevel.module2.services.ShopService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter limit: ");
        Invoice.setLimit(in.nextInt());
        ShopService.readFile();
        ShopService.stream();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(12);
        a.add(1);
        a.stream().peek(System.out::println).collect(Collectors.toList());
    }
}
