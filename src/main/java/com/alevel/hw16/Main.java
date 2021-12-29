package com.alevel.hw16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lincked = new LinkedList<>();
        List<Integer> array = new ArrayList<>();

        long time = System.currentTimeMillis();
        addInList(array);
        //takeRandom(array);
        System.out.println("ArrayList: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        addInList(lincked);
        //takeRandom(lincked);
        System.out.println("LinckedList: " + (System.currentTimeMillis() - time));

        dictionary("I want to say you hello I am here you");

        Integer[] mass = new Integer[4];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i;
        }

        Array arr = new Array(mass);
        while (arr.hasNext()) {
            System.out.println(arr.next());
        }

        CollectionStudent col = new CollectionStudent();
        for (int i = 1; i <= 5; i++) {
            col.add(new Student("Name", "Group", 3, i));
        }
        col.deduct();
        col.nextCourse();
        System.out.println(col);
    }

    static void addInList(List<Integer> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
    }

    static void takeRandom(List<Integer> list) {
        Random rand = new Random();

        //Поставил ментьше итераций так как слишком долго выполняется
        for (int i = 0; i < 10000; i++) {
            list.get(rand.nextInt(1000000));
        }
    }

    static void dictionary(String message) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = message.trim().split(" ");

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            map.put(words[i], count);
        }
        System.out.println(mapSort(map));
    }

    static Map<String, Integer> mapSort(Map<String, Integer> map) {
        String[] keys = map.keySet().toArray(new String[0]);
        Integer[] values = map.values().toArray(new Integer[0]);

        while (true) {
            boolean changed = false;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] < values[i + 1]) {
                    int tmp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = tmp;

                    String str = keys[i];
                    keys[i] = keys[i + 1];
                    keys[i + 1] = str;

                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
        map = new LinkedHashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
