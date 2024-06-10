import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        LinkedList<Record> records = DataReader.readDataFromFile("data.txt");

        // Perform sequential search on unsorted linked list
        UnsortedLinkedList3 unsortedList3 = new UnsortedLinkedList3();
        unsortedList3.head = createUnsortedLinkedList(records);

        // Perform sequential search on sorted linked list
        SortedLinkedList3 sortedList3 = new SortedLinkedList3();
        sortedList3.head = createSortedLinkedList(records);

        // Perform binary search using binary search tree
        BinarySearchTree3 bst3 = new BinarySearchTree3();
        for (Record record : records) {
            bst3.insert3(record);
        }

        // Simple command-line interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an mathCA score to search (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int mathCA = Integer.parseInt(input);
                Record resultUnsorted3 = unsortedList3.sequentialSearch3(mathCA);
                Record resultSorted3 = sortedList3.sequentialSearch3(mathCA);
                Record resultBST3 = bst3.search3(mathCA);
                if (resultUnsorted3 != null) {
                    System.out.println("Record found using unsorted linked list: " + resultUnsorted3.mathCA);
                } else {
                    System.out.println("Record not found using unsorted linked list");
                }
                if (resultSorted3 != null) {
                    System.out.println("Record found using sorted linked list: " + resultSorted3.mathCA);
                } else {
                    System.out.println("Record not found using sorted linked list");
                }
                if (resultBST3 != null) {
                    System.out.println("Record found using binary search tree: " + resultBST3.mathCA);
                } else {
                    System.out.println("Record not found using binary search tree");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid mathCA score.");
            }
        }
    }

    private static UnsortedLinkedList3.Node3 createUnsortedLinkedList(LinkedList<Record> records) {
        UnsortedLinkedList3 list3 = new UnsortedLinkedList3();
        for (Record record : records) {
            UnsortedLinkedList3.Node3 newNode3 = list3.new Node3(record);
            newNode3.next = list3.head;
            list3.head = newNode3;
        }
        return list3.head;
    }

    private static SortedLinkedList3.Node3 createSortedLinkedList(LinkedList<Record> records) {
        SortedLinkedList3 list3 = new SortedLinkedList3();
        for (Record record : records) {
            SortedLinkedList3.Node3 newNode3= list3.new Node3(record);
            if (list3.head == null || record.mathCA < list3.head.data.mathCA) {
                newNode3.next
                        = list3.head;
                list3.head = newNode3;
            } else {
                SortedLinkedList3.Node3 current = list3.head;
                while (current.next != null && current.next.data.mathCA < record.mathCA) {
                    current = current.next;
                }
                newNode3.next = current.next;
                current.next = newNode3;
            }
        }
        return list3.head;
    }
}
