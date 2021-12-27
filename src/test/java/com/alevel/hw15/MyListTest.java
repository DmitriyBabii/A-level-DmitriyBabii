package com.alevel.hw15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    MyList<Integer> list;

    @Before
    public void createList() {
        list = new MyList<>(11);
        list.add(12);
        list.add(23);
    }

    @Test
    public void add_positive() {
        list.add(33);
        assertEquals(4, list.getLength());
    }

    @Test
    public void findElement_returnElement() {
        assertEquals(Integer.valueOf(11), list.findElement(11));
    }

    @Test
    public void findElement_returnNull() {
        assertNull(list.findElement(14));
    }

    @Test
    public void getFromLast_returnElement() {
        assertEquals(Integer.valueOf(12), list.getFromLast(1));
    }

    @Test(expected = NullPointerException.class)
    public void getFromLast_exception() {
        list.getFromLast(5);
    }

    @Test
    public void getLength_positive() {
        assertEquals(3, list.getLength());
    }
}