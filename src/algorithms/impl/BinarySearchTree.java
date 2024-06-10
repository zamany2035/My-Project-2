package algorithms.impl;


class BinarySearchTree {
    Node root;

    class Node {
        StudentRecord data;
        Node left;
        Node right;

        Node(StudentRecord data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(StudentRecord data) {root = insertRec(root, data);}

    private Node insertRec(Node root
            , StudentRecord data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.id < root.data.id) {
            root.left = insertRec(root.left, data);
        } else if (data.id > root.data.id) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public StudentRecord search(int id) {
        long startTime = System.nanoTime();
        Node result = searchRec(root, id);
        long endTime = System.nanoTime();
        if (result != null) {
            System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
            return result.data;
        } else {
            System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
            return null; // Record not found
        }
    }

    private Node searchRec(Node root, int id) {
        if (root == null || root.data.id == id) {
            return root;
        }
        if (id < root.data.id) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }
}