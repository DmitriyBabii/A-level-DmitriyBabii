package com.alevel.hw15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        MyList<Integer> list = new MyList<>(15);
        list.add(14);
        list.add(213);
        System.out.println(list.findElement(14));

        Set<MyNode<Integer>> setNodes = new TreeSet<>(new MyNodeValueComparator());
        for (int i = 0; i < 5; i++) {
            setNodes.add(new MyNode<>(rand.nextInt(100)));
        }
        System.out.println(setNodes);

        Set<MyList<Integer>> setLists = new TreeSet<>(new MyListLengthComparator());
        for (int i = 0; i < 5; i++) {
            MyList<Integer> setList = new MyList<>();
            int length = rand.nextInt(6);
            for (int j = 0; j < length; j++) {
                setList.add(rand.nextInt(100));
            }
            setLists.add(setList);
        }
        System.out.println(setLists);

        MyList<String> stringMyList = new MyList<>("Hello");
        stringMyList.add("Hi");
        Map<String, Integer> map = toMap(stringMyList);
        System.out.println(map);
    }

    public static Map<String, Integer> toMap(MyList<String> nodes) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            map.put(nodes.getFromLast(i), nodes.getFromLast(i).length());
        }

        return map;
    }

}
