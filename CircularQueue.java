// Hacktoberfest 2025 Contribution

// Description: Java program to implement a Circular Queue using OOP concepts

public class CircularQueue {
    private int[] queue;   // Array to store queue elements
    private int front, rear, size, capacity;

    // Constructor to initialize Circular Queue
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.size = 0;
        this.rear = capacity - 1; // Rear starts one step behind
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an element to the queue (Enqueue)
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Move rear in a circular manner
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued to the circular queue.");
    }

    // Method to remove an element from the queue (Dequeue)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return;
        }
        System.out.println(queue[front] + " dequeued from the circular queue.");
        front = (front + 1) % capacity; // Move front circularly
        size--;
    }

    // Method to get the front element
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element.");
            return -1;
        }
        return queue[front];
    }

    // Method to get the rear element
    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No rear element.");
            return -1;
        }
        return queue[rear];
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Circular Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Main function for testing
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();

        cq.dequeue();
        cq.dequeue();

        cq.display();

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display();

        System.out.println("Front element: " + cq.peekFront());
        System.out.println("Rear element: " + cq.peekRear());
    }
}
