package com.alevel.hw15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyNodeTest {

    MyNode<Integer> node;

    @Before
    public void createMyNode() {
        node = new MyNode<>(12);
    }

    @Test
    public void setNext_positive() {
        node.setNext(13);
        assertEquals(Integer.valueOf(13), node.getLast().getValue());
    }

    @Test
    public void getValue_positive() {
        assertEquals(Integer.valueOf(12), node.getValue());
    }

    @Test
    public void getLast_positive() {
        assertEquals(node, node.getLast());
        node.setNext(13);
        assertEquals(Integer.valueOf(13), node.getLast().getValue());
    }

    @Test
    public void find_returnValue() {
        assertEquals(node.getValue(), node.find(12));
    }

    @Test
    public void find_returnNull() {
        assertNull(node.find(11));
    }

    @Test
    public void get_returnElement() {
        assertEquals(node.getValue(), node.get(0));
    }

    @Test
    public void get_returnNull() {
        assertNull(node.get(-1));
    }
}