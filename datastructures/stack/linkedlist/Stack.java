package datastructures.stack.linkedlist;

import java.util.EmptyStackException;

/**
 * Linked List implementation of a Stack
 */
public class Stack<T> {

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

    /**
     * Constructor for the stack that intializes the first value of a stack
     * 
     * @param item the first item of the stack
     */
    Stack(T item) {
        top = new Node<T>(item);
    }

    /**
     * Default Constructor for the stack that initializes empty stack
     */
    Stack() {
        top = null;
    }

    /**
     * Removes and returns the top of the stack 
     * 
     * @return the top value of the stack
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> temp = top;
        top = top.next;
        return temp.data;
    }

    /**
     * Adds an item to the stack
     * 
     * @param item the item to add
     */
    public void push(T item) {
        Node<T> temp = new Node<T>(item);
        temp.next = top;
        top = temp;
    }

    /**
     * Returns but does not remove the top element of the stack
     * 
     * @return the top value of the stack
     * @throws EmptyStackException if stack is empty
     */
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    /**
     * Determines if stack is empty
     * 
     * @return true if stack is empty, else false
     */
    public boolean isEmpty() {
        return top == null;
    }
}
