import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        LinkedList<Record> records = DataReader.readDataFromFile("data.txt");

        // Perform sequential search on unsorted linked list
        UnsortedLinkedList2 unsortedList2 = new UnsortedLinkedList2();
        unsortedList2.head = createUnsortedLinkedList(records);

        // Perform sequential search on sorted linked list
        SortedLinkedList2 sortedList2 = new SortedLinkedList2();
        sortedList2.head = createSortedLinkedList(records);

        // Perform binary search using binary search tree
        BinarySearchTree2 bst2 = new BinarySearchTree2();
        for (Record record : records) {
            bst2.insert2(record);
        }

        // Simple command-line interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an logicExam score to search (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int logicExam = Integer.parseInt(input);
                Record resultUnsorted2 = unsortedList2.sequentialSearch2(logicExam);
                Record resultSorted2 = sortedList2.sequentialSearch2(logicExam);
                Record resultBST2 = bst2.search2(logicExam);
                if (resultUnsorted2 != null) {
                    System.out.println("Record found using unsorted linked list: " + resultUnsorted2.logicExam);
                } else {
                    System.out.println("Record not found using unsorted linked list");
                }
                if (resultSorted2 != null) {
                    System.out.println("Record found using sorted linked list: " + resultSorted2.logicExam);
                } else {
                    System.out.println("Record not found using sorted linked list");
                }
                if (resultBST2 != null) {
                    System.out.println("Record found using binary search tree: " + resultBST2.logicExam);
                } else {
                    System.out.println("Record not found using binary search tree");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid logicExam score.");
            }
        }
    }

    private static UnsortedLinkedList2.Node2 createUnsortedLinkedList(LinkedList<Record> records) {
        UnsortedLinkedList2 list2 = new UnsortedLinkedList2();
        for (Record record : records) {
            UnsortedLinkedList2.Node2 newNode2 = list2.new Node2(record);
            newNode2.next = list2.head;
            list2.head = newNode2;
        }
        return list2.head;
    }

    private static SortedLinkedList2.Node2 createSortedLinkedList(LinkedList<Record> records) {
        SortedLinkedList2 list2 = new SortedLinkedList2();
        for (Record record : records) {
            SortedLinkedList2.Node2 newNode2 = list2.new Node2(record);
            if (list2.head == null || record.logicExam < list2.head.data.logicExam) {
                newNode2.next
                        = list2.head;
                list2.head = newNode2;
            } else {
                SortedLinkedList2.Node2 current = list2.head;
                while (current.next != null && current.next.data.logicExam < record.logicExam) {
                    current = current.next;
                }
                newNode2.next = current.next;
                current.next = newNode2;
            }
        }
        return list2.head;
    }
}
