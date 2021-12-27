package com.alevel.module2.services;

import com.alevel.module2.models.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopService {

    private static String[] properties = {
            "type", "series", "model",
            "diagonal", "screen type",
            "country", "price"
    };

    private static ArrayList<Invoice> list = null;

    public static void readFile() {
        BufferedReader reader = null;
        ArrayList<Technics> tech = null;

        try {
            reader = new BufferedReader(new FileReader(getReader()));
            String line = "";
            String[] row;

            if ((line = reader.readLine()) != null) {
                row = line.trim().split(",");
                tech = new ArrayList<>();

                while ((line = reader.readLine()) != null) {
                    row = line.trim().split(",");
                    Technics t = createTechnic(row);
                    if (t != null) {
                        tech.add(t);
                    }
                }
            } else {
                throw new NoData("File is empty");
            }
        } catch (NoData e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writeFile(tech);
    }

    private static File getReader() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return new File(Objects.requireNonNull(loader.getResource("orders.csv")).getFile());
    }

    private static void checkRow(String[] row) throws NoData {
        for (int i = 0; i < row.length; i++) {
            if (row[i].trim().isEmpty()) {
                throw new NoData("Have no properties");
            }
        }
    }

    private static Technics createTechnic(String[] row) {
        try {
            checkRow(row);
            switch (row[0]) {
                case "Telephone":
                    return new Telephone(row[1],
                            row[2],
                            Screen.valueOf(row[4]),
                            Integer.parseInt(row[6]));
                case "Television":
                    return new Television(row[1],
                            Integer.parseInt(row[3]),
                            Screen.valueOf(row[4]),
                            row[5],
                            Integer.parseInt(row[6]));
            }
        } catch (NoData e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Technics[] createArrayTechnics(ArrayList<Technics> arr) {
        Random rand = new Random();
        int count = 3 + rand.nextInt(10);
        Technics[] technics = new Technics[count];

        for (int i = 0; i < count; i++) {
            technics[i] = arr.get(rand.nextInt(arr.size()));
        }
        return technics;
    }

    private static Invoice generateInvoice(ArrayList<Technics> arr) {
        Technics[] technics = createArrayTechnics(arr);
        return new Invoice(technics, PersonService.generateCustomer());
    }

    private static void writeFile(ArrayList<Technics> arr) {
        File file = null;
        BufferedWriter writer = null;
        Date date = new Date();
        Invoice invoice = null;

        try {
            file = new File("Logs.txt");
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 1; i <= 3; i++) {
                invoice = generateInvoice(arr);
                writer.write(date + "\n");
                writer.write(invoice + "\n");
                addToList(invoice);
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addToList(Invoice invoice) {
        if (list == null) {
            list = new ArrayList<>();
            list.add(invoice);
        } else {
            list.add(invoice);
        }
    }

    public static void outputList() {
        System.out.println(list);
    }

    public static void stream() {
        final boolean[] flag = {true};

        list.stream()
                .peek(a -> {
                    if (flag[0]) {
                        System.out.println("Telephones: " + new Telephone().getCount() +
                                "\nTelevision: " + new Television().getCount());
                        flag[0] = false;
                    }
                }).peek(a -> Stream.of(a).min(new InvoiceComparator()).ifPresent(System.out::println))
                .collect(Collectors.toList());


    }
}

