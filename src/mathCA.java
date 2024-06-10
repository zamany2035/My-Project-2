

    class UnsortedLinkedList3 {
        Node3 head;

        class Node3 {
            Record data;
            Node3 next;

            Node3(Record data) {
                this.data = data;
                this.next = null;
            }
        }

        public Record sequentialSearch3(int mathCA) {
            long startTime = System.nanoTime();
            Node3 current = head;
            while (current != null) {
                if (current.data.mathCA == mathCA) {
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
    class SortedLinkedList3 {
        Node3 head;

        // Define Node class

        class Node3 {
            Record data;
            Node3 next;

            Node3(Record data) {
                this.data = data;
                this.next = null;
            }
        }

        // Method to perform sequential search on sorted linked list

        public Record sequentialSearch3(int mathCA) {
            long startTime = System.nanoTime();
            Node3 current = head;
            while (current != null && current.data.mathCA <= mathCA) {
                if (current.data.mathCA == mathCA) {
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

    class BinarySearchTree3 {
        Node3 root;

        class Node3 {
            Record data;
            Node3 left;
            Node3 right;

            Node3(Record data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        public void insert3(Record data) {
            root = insertRec3(root, data);
        }

        private Node3 insertRec3(Node3 root
                , Record data) {
            if (root == null) {
                root = new Node3(data);
                return root;
            }
            if (data.mathCA < root.data.mathCA) {
                root.left = insertRec3(root.left, data);
            } else if (data.mathCA > root.data.mathCA) {
                root.right = insertRec3(root.right, data);
            }
            return root;
        }

        public Record search3(int mathCA) {
            long startTime = System.nanoTime();
            Node3 result = searchRec3(root, mathCA);
            long endTime = System.nanoTime();
            if (result != null) {
                System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
                return result.data;
            } else {
                System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
                return null; // Record not found
            }
        }

        private Node3 searchRec3(Node3 root, int mathCA) {
            if (root == null || root.data.mathCA == mathCA) {
                return root;
            }
            if (mathCA < root.data.mathCA) {
                return searchRec3(root.left, mathCA);
            }
            return searchRec3(root.right, mathCA);
        }
    }


