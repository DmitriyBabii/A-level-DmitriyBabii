package com.alevel.module2.services;

import com.alevel.module2.models.*;

import java.io.*;
import java.util.*;

public class ShopService {

    private static ArrayList<Invoice> list = null;
    private static HashMap<String, Integer> map = null;

    public static void readFile() {
        BufferedReader reader = null;
        ArrayList<Technics> tech = null;

        try {
            reader = new BufferedReader(new FileReader(getReader()));
            String line = "";
            String[] row;

            if ((line = reader.readLine()) != null) {

                row = line.trim().split(",");
                setMap(row);

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

    private static void setMap(String[] row) {
        map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i].trim(), i);
        }
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
            switch (row[map.get("type")]) {
                case "Telephone":
                    return new Telephone(row[map.get("series")],
                            row[map.get("model")],
                            Screen.valueOf(row[map.get("screen type")]),
                            Integer.parseInt(row[map.get("price")]));
                case "Television":
                    return new Television(row[map.get("series")],
                            Integer.parseInt(row[map.get("diagonal")]),
                            Screen.valueOf(row[map.get("screen type")]),
                            row[map.get("country")],
                            Integer.parseInt(row[map.get("price")]));
            }
        } catch (NoData e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Technics[] createArrayTechnics(ArrayList<Technics> arr) {
        Random rand = new Random();
        int count = 1 + rand.nextInt(5);
        Technics[] technics = new Technics[count];

        for (int i = 0; i < count; i++) {
            technics[i] = arr.get(rand.nextInt(arr.size()));
        }
        return technics;
    }

    private static Invoice generateInvoice(ArrayList<Technics> arr) {
        Technics[] technics = createArrayTechnics(arr);
        return new Invoice(technics, PersonService.generateCustomer(), new Date());
    }

    private static void writeFile(ArrayList<Technics> arr) {
        File file = null;
        BufferedWriter writer = null;
        Invoice invoice = null;

        try {
            file = new File("Logs.txt");
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 15; i++) {
                invoice = generateInvoice(arr);
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

    public static void analInfo() {
        final boolean[] flag = {true};
        StreamRequest req = new StreamRequest();
        Invoice inv = null;

        System.out.println("Telephone: " + req.getCountTelephones(list) +
                "\nTelevision: " + req.getCountTelevisions(list) +
                "\nMin invoice: \n" + (inv = req.getSumMinInvoice(list)).getCustomer() + "Price: " + inv.getPrice() +
                "\n\nAll price: " + req.getSumAllInvoices(list) +
                "\nRetail: " + req.getCountRetail(list) +
                "\nOnly one type technics: " + req.getCountOnlyTypeTechnics(list) +
                "\n\nOnly tree invoices: \n" + req.getOnlyThreeInvoices(list) +
                "\n\nLow age invoices: \n" + req.getLowAgeInvoices(list) +
                "\n\nSorted invoices: " + req.getSortedInvoices(list)
        );

    }
}

