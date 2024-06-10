
    class UnsortedLinkedList2 {
        Node2 head;

        class Node2 {
            Record data;
            Node2 next;

            Node2(Record data) {
                this.data = data;
                this.next = null;
            }
        }

        public Record sequentialSearch2(int logicExam) {
            long startTime = System.nanoTime();
            Node2 current = head;
            while (current != null) {
                if (current.data.logicExam == logicExam) {
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
    class SortedLinkedList2 {
        Node2 head;

        // Define Node class

        class Node2 {
            Record data;
            Node2 next;

            Node2(Record data) {
                this.data = data;
                this.next = null;
            }
        }

        // Method to perform sequential search on sorted linked list

        public Record sequentialSearch2(int logicExam) {
            long startTime = System.nanoTime();
            Node2 current = head;
            while (current != null && current.data.logicExam <= logicExam) {
                if (current.data.logicExam == logicExam) {
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

    class BinarySearchTree2 {
        Node2 root;

        class Node2 {
            Record data;
            Node2 left;
            Node2 right;

            Node2(Record data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        public void insert2(Record data) {
            root = insertRec2(root, data);
        }

        private Node2 insertRec2(Node2 root
                , Record data) {
            if (root == null) {
                root = new Node2(data);
                return root;
            }
            if (data.logicExam < root.data.logicExam) {
                root.left = insertRec2(root.left, data);
            } else if (data.logicExam > root.data.logicExam) {
                root.right = insertRec2(root.right, data);
            }
            return root;
        }

        public Record search2(int logicCA) {
            long startTime = System.nanoTime();
            Node2 result = searchRec2(root, logicCA);
            long endTime = System.nanoTime();
            if (result != null) {
                System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
                return result.data;
            } else {
                System.out.println("Binary search using binary search tree took " + (endTime - startTime) + " nanoseconds");
                return null; // Record not found
            }
        }

        private Node2 searchRec2(Node2 root, int logicExam) {
            if (root == null || root.data.logicExam == logicExam) {
                return root;
            }
            if (logicExam < root.data.logicExam) {
                return searchRec2(root.left, logicExam);
            }
            return searchRec2(root.right, logicExam);
        }
    }


