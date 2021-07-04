package datastructures.stack.linkedlist;

import java.util.EmptyStackException;

public class StackTest {


    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(3);
        stack.push(-1);

        System.out.println("Assert: -1 == " + stack.peek());
        
        int popped = stack.pop();

        System.out.println("Assert: -1 == " + popped);
        
        stack.pop();

        System.out.println("Assert: 2 == " + stack.peek());

        stack.pop();

        System.out.println("Assert: true == " + stack.isEmpty());

        try {
            stack.pop();
        } catch(EmptyStackException e) {
            System.out.println("Correct exception caught!");
        }
    }

}