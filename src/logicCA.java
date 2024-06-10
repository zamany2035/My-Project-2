
class UnsortedLinkedList1 {
    Node1 head;

    class Node1 {
        Record data;
        Node1 next;

        Node1(Record data) {
            this.data = data;
            this.next = null;
        }
    }

    public Record sequentialSearch1(int logicCA) {
        long startTime = System.nanoTime();
        Node1 current = head;
        while (current != null) {
            if (current.data.logicCA == logicCA) {
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
 class SortedLinkedList1 {
    Node1 head;

    // Define Node class

    class Node1 {
        Record data;
        Node1 next;

        Node1(Record data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to perform sequential search on sorted linked list

    public Record sequentialSearch1(int logicCA) {
        long startTime = System.nanoTime();
        Node1 current = head;
        while (current != null && current.data.logicCA <= logicCA) {
            if (current.data.logicCA == logicCA) {
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

class BinarySearchTree1 {
    Node1 root;

    class Node1 {
        Record data;
        Node1 left;
        Node1 right;

        Node1(Record data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert1(Record data) {
        root = insertRec1(root, data);
    }

    private Node1 insertRec1(Node1 root
            , Record data) {
        if (root == null) {
            root = new Node1(data);
            return root;
        }
        if (data.logicCA < root.data.logicCA) {
            root.left = insertRec1(root.left, data);
        } else if (data.logicCA > root.data.logicCA) {
            root.right = insertRec1(root.right, data);
        }
        return root;
    }

    public Record search1(int logicCA) {
        long startTime = System.nanoTime();
        Node1 result = searchRec1(root, logicCA);
        long endTime = System.nanoTime();
        if (result != null) {
            System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
            return result.data;
        } else {
            System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
            return null; // Record not found
        }
    }

    private Node1 searchRec1(Node1 root, int logicCA) {
        if (root == null || root.data.logicCA == logicCA) {
            return root;
        }
        if (logicCA < root.data.logicCA) {
            return searchRec1(root.left, logicCA);
        }
        return searchRec1(root.right, logicCA);
    }
}
