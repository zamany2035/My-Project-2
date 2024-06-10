    package algorithms.impl;

    import algorithms.interfaces.SearchComparison;

    import java.util.LinkedList;


    public class SearchComparisonImpl implements SearchComparison {
        public CustomLinkedList<LinkedList<StudentRecord>> getUnsortedList(){
            int stop = 0;
    //        System.out.println(unsortedList.head.data.name);
            CustomLinkedList.Node node = unsortedList.head;
            System.out.print('[');
            while(node != null && stop<10000) {
                stop++;
                System.out.print(node.data.name);
                System.out.print(',');
                node = node.next;

            }
            System.out.print(']');
    //        System.out.print(record.)
                return unsortedList;
        }

        public CustomLinkedList<LinkedList<StudentRecord>> getSortedList(){
            int stop = 0;
    //        System.out.println(sortedList.head.data.name);
            CustomLinkedList.Node node = sortedList.head;
            System.out.print('[');
            while(node != null && stop<10000) {
                stop++;
                System.out.print(node.data.name);
                System.out.print(',');
                node = node.next;

            }
            System.out.print(']');
    //        System.out.print(record.)
            return sortedList;
        }
        public BinarySearchTree getBinaryTree() {
            return this.binarySearchTree;


        }

        CustomLinkedList<LinkedList<StudentRecord>> unsortedList;
        CustomLinkedList<LinkedList<StudentRecord>> sortedList;
        BinarySearchTree binarySearchTree;
        LinkedList<StudentRecord> record;
        public SearchComparisonImpl(){
            // initializationRecord.javaRecord.java

            LinkedList<StudentRecord> records = DataReader.readDataFromFile("data.txt");
            this.record = records;

            generateUnsortedList();
            generateSortedList();
            generateBinaryTree();
            System.out.println("Successfully initialised");

        }

        /**
         * - @sampleSpace 1000,5000,10000*/
        SearchComparisonImpl(Double recordLentht){
            generateBinaryTree();
            generateSortedList();
            generateUnsortedList();
            System.out.println("Successfully initialised");
        }


        public   void generateUnsortedList() {
            CustomLinkedList<LinkedList<StudentRecord>> list = new CustomLinkedList<LinkedList<StudentRecord>>();
            for (StudentRecord record : this.record) {

                CustomLinkedList.Node newNode = list.new Node(record);
                if (list.head == null || record.id < list.head.data.id) {
                    newNode.next = list.head;
                    list.head = newNode;
                } else {
                    CustomLinkedList.Node current = list.head;
                    while (current.next != null && current.next.data.id < record.id) {
                        current =
                                current.next;
                    }
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }

            // create unsorted linked list
            CustomLinkedList<LinkedList<StudentRecord>> unsortedList = new CustomLinkedList<LinkedList<StudentRecord>>();
            this.unsortedList = unsortedList;
            this.unsortedList.head = list.head;




        }

        public   void generateSortedList() {
            CustomLinkedList<LinkedList<StudentRecord>> list = new CustomLinkedList<LinkedList<StudentRecord>>();
            for (StudentRecord record : this.record) {

                CustomLinkedList.Node newNode = list.new Node(record);
                if (list.head == null || record.id < list.head.data.id) {
                    newNode.next = list.head;
                    list.head = newNode;
                } else {
                    CustomLinkedList.Node current = list.head;
                    while (current.next != null && current.next.data.id < record.id) {
                        current =
                current.next;
                    }
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }

            // create sorted linked list
            CustomLinkedList<LinkedList<StudentRecord>> sortedList = new CustomLinkedList<LinkedList<StudentRecord>>();
            this.sortedList = sortedList;
            this.sortedList.head = list.head;



    }



        public void generateBinaryTree() {
            BinarySearchTree bst = new BinarySearchTree();
            for (StudentRecord record : record) {
                bst.insert(record);

            }
    this.binarySearchTree=bst;

        }


    public void searchWithId(int id){
        long startTime = System.nanoTime();
        CustomLinkedList.Node current = this.sortedList.head;
        long endTime;
        boolean isFound = false;
        // Searching in sorted list
        while (current != null) {
            if (current.data.id == id) {
                isFound = true;
                 endTime = System.nanoTime();
                 current = null;
                // Searching in sorted list
                System.out.println("Searching for ID in sorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
            } else {
                current = current.next;
            }
        }

        if (isFound == false) {
            endTime = System.nanoTime();
            System.out.println("Entered ID not found in sorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
        }
        // Searching in unsorted list
                startTime = System.nanoTime();
               isFound = false;
                current = this.unsortedList.head;
                while (current != null) {
                    if (current.data.id == id) {
                        isFound = true;
                        endTime = System.nanoTime();
                        current = null;
                        // Searching in unsorted list
                        System.out.println("Searching For ID in unsorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
                    }
                    else {current = current.next;}
                }
        if (isFound == false) {
            endTime = System.nanoTime();
            System.out.println("Entered ID not found in unsorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
        }
    // search with Binary search tree
                        startTime = System.nanoTime();
                        BinarySearchTree.Node bst = this.binarySearchTree.root;
                        isFound = false;
                        while (bst != null) {
                            if (bst.data.id == id) {
                                isFound = true;
                                endTime = System.nanoTime();
                                System.out.println("Searching for ID in binarySearchTree"+ " "+"Search Time :" + (endTime - startTime) + " nanoseconds");
                                bst = null;
                                continue;
                            } else if (bst.data.id > id) {
                                bst = bst.right;
                            } else {
                                bst = bst.left;

                            }

                        }
                        if (isFound == false) {
                            endTime = System.nanoTime();
                            System.out.println("Entered ID not found in BinaryTree" +"Search Time :"+ (endTime - startTime) + " nanoseconds");
                        }

                    }

        public void searchWithName(String name) {
            long startTime = System.nanoTime();

            LinkedList<BinarySearchTree.Node> queue = new LinkedList<>();
            queue.add(this.binarySearchTree.root);

            boolean isFound = false;

            while (!queue.isEmpty()) {
                BinarySearchTree.Node currentNode = queue.poll();

                if (currentNode.data.name.equals(name)) {
                    isFound = true;
                    break;
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            long endTime = System.nanoTime();

            if (isFound) {
                System.out.println("Name found in binarySearchTree. Search Time: " + (endTime - startTime) + " nanoseconds");
            } else {
                System.out.println("Name not found in binarySearchTree. Search Time: " + (endTime - startTime) + " nanoseconds");
            }
        }

      public   void searchWithCa(String course, int caScore) {

          long startTime = System.nanoTime();
          CustomLinkedList.Node current = this.sortedList.head;
          long endTime;
          boolean isFound = false;
          // Searching in sorted list
          while (current != null) {
              if (current.data.id == id) {
                  isFound = true;
                  endTime = System.nanoTime();
                  current = null;
                  // Searching in sorted list
                  System.out.println("Searching for ID in sorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
              } else {
                  current = current.next;
              }
          }

          if (isFound == false) {
              endTime = System.nanoTime();
              System.out.println("Entered ID not found in sorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
          }
          // Searching in unsorted list
          startTime = System.nanoTime();
          isFound = false;
          current = this.unsortedList.head;
          while (current != null) {
              if (current.data.id == id) {
                  isFound = true;
                  endTime = System.nanoTime();
                  current = null;
                  // Searching in unsorted list
                  System.out.println("Searching For ID in unsorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
              }
              else {current = current.next;}
          }
          if (isFound == false) {
              endTime = System.nanoTime();
              System.out.println("Entered ID not found in unsorted list" + " "+"Search Time :"+ (endTime - startTime) + " nanoseconds");
          }
          // search with Binary search tree
          startTime = System.nanoTime();
          BinarySearchTree.Node bst = this.binarySearchTree.root;
          isFound = false;
          while (bst != null) {
              if (bst.data.id == id) {
                  isFound = true;
                  endTime = System.nanoTime();
                  System.out.println("Searching for ID in binarySearchTree"+ " "+"Search Time :" + (endTime - startTime) + " nanoseconds");
                  bst = null;
                  continue;
              } else if (bst.data.id > id) {
                  bst = bst.right;
              } else {
                  bst = bst.left;

              }

          }
          if (isFound == false) {
              endTime = System.nanoTime();
              System.out.println("Entered ID not found in BinaryTree" +"Search Time :"+ (endTime - startTime) + " nanoseconds");
          }

      }

        public void searchWitExam(String course, int examScore){
           // Searching in sorted list
           System.out.println("Searching in sorted list");



           // Searching in unsorted list
           System.out.println("Searching in unsorted list");



           // Searching in binarySearchTree
           System.out.println("Searching in binarySearchTree");


       }
        public void sequentialSearch(int logicCA) {
            long startTime = System.nanoTime();
            CustomLinkedList.Node current = unsortedList.head;
            while (current != null) {
                if (current.data.logicCA == logicCA) {
                    long endTime = System.nanoTime();
                    System.out.println("Sequential search on unsorted linked list took " + (endTime - startTime) + " nanoseconds");

                }
                current = current.next;
            }
            long endTime = System.nanoTime();
            System.out.println("Sequential search on unsorted linked list took " + (endTime - startTime) + " nanoseconds");
        }
    }
