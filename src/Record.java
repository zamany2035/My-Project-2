import java.io.*;
import java.util.LinkedList;
import java.util.Random;

class Record {
    int id;
    String name;
    int mathCA;
    int mathExam;
    int physicsCA;
    int physicsExam;
    int logicCA;
    int logicExam;
}


 class DataReader {
    public static LinkedList<Record> readDataFromFile(String fileName) {
        LinkedList<Record> records = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Record record = new Record();
                record.id = Integer.parseInt(data[0]);
                record.name = data[1];
                record.mathCA = Integer.parseInt(data[2]);
                record.mathExam = Integer.parseInt(data[3]);
                record.physicsCA = Integer.parseInt(data[4]);
                record.physicsExam = Integer.parseInt(data[5]);
                record.logicCA = Integer.parseInt(data[6]);
                record.logicExam = Integer.parseInt(data[7]);
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}

class UnsortedLinkedList {
    Node head;

    class Node {
        Record data;
        Node next;

        Node(Record data) {
            this.data = data;
            this.next = null;
        }
    }

    public Record sequentialSearch(int id) {
        long startTime = System.nanoTime();
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                long endTime = System.nanoTime();
                System.out.println("Sequential search on unsorted linked list took " + (endTime - startTime) + " nanoseconds");
                return current.data;
            }
            current = current.next;
        }
        long endTime = System.nanoTime();
        System.out.println("Sequential search on unsorted linked list took " + (endTime - startTime) + " nanoseconds");
        return null; // Record not found
    }
}
class SortedLinkedList {
    Node head;

    // Define Node class

    class Node {
        Record data;
        Node next;

        Node(Record data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to perform sequential search on sorted linked list

    public Record sequentialSearch(int id) {
        long startTime = System.nanoTime();
        Node current = head;
        while (current != null && current.data.id <= id) {
            if (current.data.id == id) {
                long endTime = System.nanoTime();
                System.out.println("Sequential search on sorted linked list took " + (endTime - startTime) + " nanoseconds");
                return current.data;
            }
            current = current.next;
        }
        long endTime = System.nanoTime();
        System.out.println("Sequential search on sorted linked list took " + (endTime - startTime) + " nanoseconds");
        return null; // Record not found
    }
}

class BinarySearchTree {
    Node root;

    class Node {
        Record data;
        Node left;
        Node right;

        Node(Record data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(Record data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root
            , Record data) {
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

    public Record search(int id) {
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






