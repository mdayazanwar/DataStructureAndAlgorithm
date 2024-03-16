package Queue;

public class Queue {
    int[] array;
    int front;
    int rear;
    int size;
    int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
            array = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
    }

    public void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public int dequeue(){
        if( isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item =  array[front];
        front = (front + 1) % capacity;
        size --;
        return item;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("queue is empty ");
            return -1;
        }
        return array[front];
    }

    boolean isEmpty() {
        return  size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }
}

