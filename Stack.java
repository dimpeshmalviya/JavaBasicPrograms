// Stack implementation in Java using arrays

// A Stack follows LIFO (Last In First Out) principle.
// This means the last element inserted is the first one to be removed.

public class Stack {
    // Maximum size of the stack
    private static final int MAX = 5;

    // Array to store stack elements
    private int[] stack = new int[MAX];

    // 'top' keeps track of the index of the top element in the stack
    private int top;

    // Constructor: initialize top to -1 (indicating empty stack)
    public Stack() {
        top = -1;
    }

    // Method to check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if stack is full
    public boolean isFull() {
        return (top == MAX - 1);
    }

    // Method to push an element into the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stack[++top] = value; // increment top and add value
            System.out.println(value + " pushed into stack.");
        }
    }

    // Method to pop (remove) the top element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop element.");
            return -1; // return an invalid value
        } else {
            int poppedValue = stack[top--]; // return top element then decrement top
            System.out.println(poppedValue + " popped from stack.");
            return poppedValue;
        }
    }

    // Method to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Method to display all elements of stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Stack s = new Stack();

        // Push elements into the stack
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        // Attempt to push one more (will cause overflow)
        s.push(60);

        // Display current stack
        s.display();

        // View top element
        System.out.println("Top element is: " + s.peek());

        // Pop elements from stack
        s.pop();
        s.pop();

        // Display stack after popping
        s.display();

        // Peek again
        System.out.println("New top element is: " + s.peek());
    }
}
