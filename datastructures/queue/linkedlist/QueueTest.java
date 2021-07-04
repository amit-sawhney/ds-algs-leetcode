package datastructures.queue.linkedlist;

public class QueueTest {

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        test("Queue is empty", queue.isEmpty());

        try {
            queue.peek();
        } catch (Exception e) {
            test("Empty queue does not peek", e.getMessage().compareTo("Queue is empty.") == 0);
        }

        try {
            queue.rear();
        } catch (Exception e) {
            test("Empty queue does not show rear", e.getMessage().compareTo("Queue is empty.") == 0);
        }

        try {
            queue.remove();
        } catch (Exception e) {
            test("Empty queue does not return last element", e.getMessage().compareTo("Queue is empty.") == 0);
        }

        queue.add(1);
        
        test("Add first element", queue.peek() == queue.rear() && queue.peek() == 1);
        
        queue.add(2);
        test("Add second element", queue.peek() == 1 && queue.rear() == 2);

        int item1 = queue.remove();
        test("Remove element from queue with size more than 1", item1 == 1 && queue.peek() == 2 && queue.rear() == 2);

        int item2 = queue.remove();
        test("Empty a populated queue", item2 == 2 && queue.isEmpty());

        try {
            queue.peek();
        } catch (Exception e) {
            test("Empty queue does not peek", e.getMessage().compareTo("Queue is empty.") == 0);
        }

        try {
            queue.rear();
        } catch (Exception e) {
            test("Empty queue does not show rear", e.getMessage().compareTo("Queue is empty.") == 0);
        }

    }

    private static void test(String message, boolean didPass) {
        System.out.println(message + ": " + (didPass ? "Passed" : "*****Failed*****"));
    }
}
