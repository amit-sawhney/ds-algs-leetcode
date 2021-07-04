package datastructures.queue.linkedlist;

import java.util.NoSuchElementException;

public class Queue<T> {

    /**
     * Node element to hold each element of the linked list implmentation
     */
    private static class Node<T> {

        T data;
        Node<T> next;

        /**
         * Constructor for Node to initialize data value
         * 
         * @param data the data to put into the node
         */
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;
    private Node<T> rear;

    Queue() {
        top = null;
        rear = null;
    }

    Queue(T item) {
        top = new Node<T>(item);
        rear = top;
    }

    public void add(T item) {

        Node<T> node = new Node<T>(item);
        if (rear != null) {
            rear.next = node;
        }

        rear = node;

        if (top == null) {
            top = rear;
        }
    }

    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }

        Node<T> currentTop = top;
        top = top.next;

        if (top == null) {
            rear = null;
        }

        return currentTop.data;

    }

    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return top.data;
    }

    public T rear() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }

        return rear.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
