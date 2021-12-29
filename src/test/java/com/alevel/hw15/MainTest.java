package com.alevel.hw15;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void toMap_positive() {
        MyList<String> list = new MyList<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        list.add("Hello");
        list.add("Hi");
        list.add("Dog");

        map.put("Hello", 5);
        map.put("Hi", 2);
        map.put("Dog", 3);

        assertEquals(map, Main.toMap(list));
    }

}