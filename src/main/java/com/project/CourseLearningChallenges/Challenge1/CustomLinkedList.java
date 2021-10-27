package com.project.CourseLearningChallenges.Challenge1;

import java.util.Iterator;

/**
 * A doubly-linked list that can return its middle element.
 *
 * @param <T>
 */

public class CustomLinkedList<T> implements Iterable<T> {

    class Node {
        private T t;
        private Node next;
        private Node prev;

        public Node(T t) {
            this.t = t;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public CustomLinkedList(T... t) {

        if(t.length != 0) {
            Node head = new Node(t[0]), tail = head;
            for (int i = 1; i < t.length; i++) {
                tail.next = new Node(t[i]);
                tail.next.prev = tail;
                tail = tail.next;
            }

            this.head = head;
            this.tail = tail;
            this.size = t.length;
        }
    }

    public void append(T... t) {

        if(t.length == 0)
            throw new IllegalArgumentException("Number of input arguments should not be zero.");

        int i = 0;
        if(size == 0) {
            head = new Node(t[0]);
            tail = head;
            i = 1;
        }

        for(; i < t.length; i++) {
            tail.next = new Node(t[i]);
            tail.next.prev = tail;
            tail = tail.next;
        }

        this.size += t.length;
    }

    public T getMiddleElement() throws IllegalCallerException {
/*
        if(size % 2 == 0)
            throw new IllegalCallerException("Invalid length : Linked List having an even number of elements cannot have a middle node.");
 */

        Node x = head, y = tail;
        while(x != y && x.next != y) {
            x = x.next;
            y = y.prev;
        }
        return y.t;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T t = current.t;
                current = current.next;
                return t;
            }
        };
        return iterator;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("{ ");
        Node current = head;
        while(current != null) {
            stringBuilder.append(current.t);
            if(current != tail)
                stringBuilder.append(", ");
            current = current.next;
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
    }
}
