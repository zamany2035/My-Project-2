import java.util.LinkedList;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        LinkedList<Record> records = DataReader.readDataFromFile("data.txt");

        // Perform sequential search on unsorted linked list
        UnsortedLinkedList1 unsortedList1 = new UnsortedLinkedList1();
        unsortedList1.head = createUnsortedLinkedList(records);

        // Perform sequential search on sorted linked list
        SortedLinkedList1 sortedList1 = new SortedLinkedList1();
        sortedList1.head = createSortedLinkedList(records);

        // Perform binary search using binary search tree
        BinarySearchTree1 bst1 = new BinarySearchTree1();
        for (Record record : records) {
            bst1.insert1(record);
        }

        // Simple command-line interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a logicCA score to search (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int logicCA = Integer.parseInt(input);
                Record resultUnsorted1 = unsortedList1.sequentialSearch1(logicCA);
                Record resultSorted1 = sortedList1.sequentialSearch1(logicCA);
                Record resultBST1 = bst1.search1(logicCA);
                if (resultUnsorted1 != null) {
                    System.out.println("Record found using unsorted linked list: " + resultUnsorted1.logicCA);
                } else {
                    System.out.println("Record not found using unsorted linked list");
                }
                if (resultSorted1 != null) {
                    System.out.println("Record found using sorted linked list: " + resultSorted1.logicCA);
                } else {
                    System.out.println("Record not found using sorted linked list");
                }
                if (resultBST1 != null) {
                    System.out.println("Record found using binary search tree: " + resultBST1.logicCA);
                } else {
                    System.out.println("Record not found using binary search tree");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
            }
        }
    }

    private static UnsortedLinkedList1.Node1 createUnsortedLinkedList(LinkedList<Record> records) {
        UnsortedLinkedList1 list1 = new UnsortedLinkedList1();
        for (Record record : records) {
            UnsortedLinkedList1.Node1 newNode1 = list1.new Node1(record);
            newNode1.next = list1.head;
            list1.head = newNode1;
        }
        return list1.head;
    }

    private static SortedLinkedList1.Node1 createSortedLinkedList(LinkedList<Record> records) {
        SortedLinkedList1 list1 = new SortedLinkedList1();
        for (Record record : records) {
            SortedLinkedList1.Node1 newNode1 = list1.new Node1(record);
            if (list1.head == null || record.logicCA < list1.head.data.logicCA) {
                newNode1.next
                        = list1.head;
                list1.head = newNode1;
            } else {
                SortedLinkedList1.Node1 current = list1.head;
                while (current.next != null && current.next.data.logicCA < record.logicCA) {
                    current = current.next;
                }
                newNode1.next = current.next;
                current.next = newNode1;
            }
        }
        return list1.head;
    }

}
