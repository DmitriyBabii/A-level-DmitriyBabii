package com.alevel.module2;

import com.alevel.module2.models.Invoice;
import com.alevel.module2.services.ShopService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter limit: ");
        Invoice.setLimit(in.nextInt());
        ShopService.readFile();
        ShopService.analInfo();
    }
}
