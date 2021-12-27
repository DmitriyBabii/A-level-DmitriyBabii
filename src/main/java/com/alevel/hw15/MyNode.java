package com.alevel.hw15;

public class MyNode<E> {
    private E value;
    private MyNode<E> next;
    private MyNode<E> prev;

    MyNode(E value) {
        this.value = value;
        next = null;
        prev = null;
    }

    private MyNode(E value, MyNode<E> next, MyNode<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public void setNext(E value) {
        if (this.next == null) {
            this.next = new MyNode<>(value, null, this);
        } else {
            this.next.setNext(value);
        }
    }

    public E getValue() {
        return value;
    }

    public MyNode<E> getLast() {
        if (next == null) {
            return this;
        } else {
            return next.getLast();
        }
    }

    public E find(E value) {
        if (this.value.hashCode() == value.hashCode()
                && this.value.equals(value)) {
            return value;
        } else if (prev != null) {
            return prev.find(value);
        }
        return null;
    }

    public E get(int index) {
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return this.value;
        }
        return this.prev.get(--index);
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
