import java.util.HashMap;

public class LRUCache {
    class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int limit;
    private HashMap<Integer, Node> map = new HashMap<>();

    private void addNode(Node newNode) {
        Node oldNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldNext;
        oldNext.prev = newNode;
    }

    private void delNode(Node oldNode) {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node ansNode = map.get(key);
            int ans = ansNode.value;
            delNode(ansNode);
            addNode(ansNode);
            return ans;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }

        if (map.size() == limit) {
            map.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

    // Main method for testing
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity 2

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);                  // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4);                  // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
