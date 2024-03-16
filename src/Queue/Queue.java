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
            System.out.println("Queue is full"); // We can also implement dynamic resizing in case array is full. But it has its own overhead. PLease refer resize function. It is not used in here.
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

    private void resizeArray() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }
}

