package com.alevel.hw15;

public class MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int length;

    MyList() {
        head = null;
        tail = null;
        length = 0;
    }

    MyList(E value) {
        head = new MyNode<>(value);
        tail = head;
        length = 1;
    }

    public void add(E value) {
        if (head == null) {
            head = new MyNode<>(value);
            tail = head;
        } else {
            head.setNext(value);
            tail = head.getLast();
        }
        length++;
    }

    public E findElement(E value) {
        if(tail!=null){
            return tail.find(value);
        }
        return null;
    }

    public E getFromLast(int index) {
        return tail.get(index);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "head=" + head +
                ", length=" + length +
                "}\n";
    }
}
