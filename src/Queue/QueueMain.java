package Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Peeked element: " + queue.peek());

        queue.enqueue(6);
        queue.enqueue(7);

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

    }
}
