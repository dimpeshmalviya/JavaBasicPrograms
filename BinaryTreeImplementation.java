/**
 * Binary Tree Implementation in Java
 * 
 * Description: A complete implementation of a binary tree data structure
 * with insertion, traversal methods (inorder, preorder, postorder), search,
 * and various utility functions.
 * 
 * Time Complexity:
 * - Insertion: O(log n) average, O(n) worst case
 * - Search: O(log n) average, O(n) worst case
 * - Traversal: O(n) for all traversal methods
 * 
 * Space Complexity: O(n) for storing the tree, O(h) for recursion stack
 * where h is the height of the tree
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeImplementation {
    private TreeNode root;
    
    public BinaryTreeImplementation() {
        this.root = null;
    }
    
    /**
     * Insert a new node in the binary tree (level order insertion)
     * @param data The value to insert
     */
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.add(current.left);
            }
            
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    /**
     * Insert nodes in BST manner (Binary Search Tree)
     * @param data The value to insert
     */
    public void insertBST(int data) {
        root = insertBSTRecursive(root, data);
    }
    
    private TreeNode insertBSTRecursive(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        
        if (data < node.data) {
            node.left = insertBSTRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = insertBSTRecursive(node.right, data);
        }
        
        return node;
    }
    
    /**
     * Inorder traversal (Left -> Root -> Right)
     */
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderRecursive(root);
        System.out.println();
    }
    
    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }
    
    /**
     * Preorder traversal (Root -> Left -> Right)
     */
    public void preorderTraversal() {
        System.out.print("Preorder Traversal: ");
        preorderRecursive(root);
        System.out.println();
    }
    
    private void preorderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }
    
    /**
     * Postorder traversal (Left -> Right -> Root)
     */
    public void postorderTraversal() {
        System.out.print("Postorder Traversal: ");
        postorderRecursive(root);
        System.out.println();
    }
    
    private void postorderRecursive(TreeNode node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * Level order traversal (Breadth-First Search)
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        System.out.print("Level Order Traversal: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
    
    /**
     * Search for a value in the binary tree
     * @param data The value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        return searchRecursive(root, data);
    }
    
    private boolean searchRecursive(TreeNode node, int data) {
        if (node == null) {
            return false;
        }
        
        if (node.data == data) {
            return true;
        }
        
        return searchRecursive(node.left, data) || searchRecursive(node.right, data);
    }
    
    /**
     * Find the height/depth of the tree
     * @return The height of the tree
     */
    public int getHeight() {
        return calculateHeight(root);
    }
    
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Count the total number of nodes in the tree
     * @return Total node count
     */
    public int countNodes() {
        return countNodesRecursive(root);
    }
    
    private int countNodesRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }
    
    /**
     * Check if the tree is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Find the minimum value in the tree
     * @return The minimum value
     */
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMinRecursive(root);
    }
    
    private int findMinRecursive(TreeNode node) {
        int min = node.data;
        
        if (node.left != null) {
            min = Math.min(min, findMinRecursive(node.left));
        }
        if (node.right != null) {
            min = Math.min(min, findMinRecursive(node.right));
        }
        
        return min;
    }
    
    /**
     * Find the maximum value in the tree
     * @return The maximum value
     */
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMaxRecursive(root);
    }
    
    private int findMaxRecursive(TreeNode node) {
        int max = node.data;
        
        if (node.left != null) {
            max = Math.max(max, findMaxRecursive(node.left));
        }
        if (node.right != null) {
            max = Math.max(max, findMaxRecursive(node.right));
        }
        
        return max;
    }
    
    /**
     * Check if the tree is a Binary Search Tree
     * @return true if BST, false otherwise
     */
    public boolean isBST() {
        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBSTRecursive(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        if (node.data <= min || node.data >= max) {
            return false;
        }
        
        return isBSTRecursive(node.left, min, node.data) && 
               isBSTRecursive(node.right, node.data, max);
    }
    
    /**
     * Display tree structure (simple visualization)
     */
    public void displayTree() {
        System.out.println("\nTree Structure:");
        displayTreeRecursive(root, 0);
        System.out.println();
    }
    
    private void displayTreeRecursive(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        displayTreeRecursive(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        
        displayTreeRecursive(node.left, level + 1);
    }
    
    // Main method for testing
    public static void main(String[] args) {
        BinaryTreeImplementation tree = new BinaryTreeImplementation();
        
        System.out.println("=== Binary Tree Implementation ===");
        System.out.println("Creating and testing binary tree...\n");
        
        // Test insertion
        System.out.println("Inserting values: 10, 5, 15, 3, 7, 12, 18");
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        
        // Test traversals
        tree.inorderTraversal();
        tree.preorderTraversal();
        tree.postorderTraversal();
        tree.levelOrderTraversal();
        
        // Test utility functions
        System.out.println("\nTree Properties:");
        System.out.println("Height: " + tree.getHeight());
        System.out.println("Total nodes: " + tree.countNodes());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());
        System.out.println("Is BST: " + tree.isBST());
        
        // Test search
        System.out.println("\nSearch Operations:");
        System.out.println("Search 7: " + tree.search(7));
        System.out.println("Search 20: " + tree.search(20));
        
        // Display tree structure
        tree.displayTree();
        
        // Test BST insertion
        System.out.println("\n=== Testing BST Insertion ===");
        BinaryTreeImplementation bst = new BinaryTreeImplementation();
        System.out.println("Inserting values in BST manner: 50, 30, 70, 20, 40, 60, 80");
        bst.insertBST(50);
        bst.insertBST(30);
        bst.insertBST(70);
        bst.insertBST(20);
        bst.insertBST(40);
        bst.insertBST(60);
        bst.insertBST(80);
        
        bst.inorderTraversal();
        System.out.println("Is BST: " + bst.isBST());
        bst.displayTree();
        
        System.out.println("\n=== All operations completed successfully! ===");
    }
}
