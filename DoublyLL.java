class Node {
    int data;
    Node prev;
    Node next;

    Node(int x) {
        data = x;
        prev = next = null;
    }
}

public class DoublyLL {

    // 🧩 Insert at beginning
    public Node insertAtBeginning(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        return temp;
    }

    // 🧩 Insert at end
    public Node insertAtEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) return temp;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    // 🧩 Insert at specific position (1-based index)
    public Node insertAtPosition(Node head, int pos, int x) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return head;
        }

        if (pos == 1) return insertAtBeginning(head, x);

        Node temp = new Node(x);
        Node curr = head;

        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of bounds!");
            return head;
        }

        temp.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = temp;
        }
        curr.next = temp;
        temp.prev = curr;

        return head;
    }

    // 🧩 Delete from beginning
    public Node deleteAtBeginning(Node head) {
        if (head == null) return null;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }

    // 🧩 Delete from end
    public Node deleteAtEnd(Node head) {
        if (head == null || head.next == null) return null;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;
        return head;
    }

    // 🧩 Delete at specific position (1-based index)
    public Node deleteAtPosition(Node head, int pos) {
        if (head == null || pos <= 0) return head;

        if (pos == 1) return deleteAtBeginning(head);

        Node curr = head;

        for (int i = 1; i < pos && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of bounds!");
            return head;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }

        return head;
    }

    // 🧩 Reverse the doubly linked list
    public Node reverse(Node head) {
        if (head == null) return null;

        Node curr = head, prevNode = null;
        while (curr != null) {
            prevNode = curr.prev;
            curr.prev = curr.next;
            curr.next = prevNode;
            curr = curr.prev;
        }

        if (prevNode != null) {
            head = prevNode.prev;
        }
        return head;
    }

    // 🧩 Print list forward
    public void printList(Node head) {
        Node curr = head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 🧩 Print list backward
    public void printReverse(Node head) {
        if (head == null) return;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    // 🧩 Example usage
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        Node head = null;

        head = dll.insertAtEnd(head, 10);
        head = dll.insertAtEnd(head, 20);
        head = dll.insertAtEnd(head, 30);
        head = dll.insertAtBeginning(head, 5);
        head = dll.insertAtPosition(head, 3, 15);

        dll.printList(head);
        dll.printReverse(head);

        head = dll.deleteAtBeginning(head);
        head = dll.deleteAtEnd(head);
        head = dll.deleteAtPosition(head, 2);

        dll.printList(head);
        dll.printReverse(head);

        head = dll.reverse(head);
        System.out.println("After reversal:");
        dll.printList(head);
        dll.printReverse(head);
    }
}
