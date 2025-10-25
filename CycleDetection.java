// Floyd's Cycle Detection Algorithm in Java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class CycleDetection {

    // Function to detect cycle in linked list
    public static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;  // Tortoise
        Node fast = head;  // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) {       // cycle detected
                return true;
            }
        }

        return false;  // no cycle
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a cycle for testing: last node points to node 2
        head.next.next.next.next.next = head.next;

        if (hasCycle(head))
            System.out.println("Cycle detected in the linked list.");
        else
            System.out.println("No cycle detected in the linked list.");
    }
}
