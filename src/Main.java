 import algorithms.impl.CustomLinkedList;
 import algorithms.impl.SearchComparisonImpl;
 import algorithms.impl.StudentRecord;
 import algorithms.interfaces.SearchComparison;

 import java.util.LinkedList;
 import java.util.Scanner;

 public class Main {
        public static void main(String[] args) {

            SearchComparisonImpl searchComparison = new SearchComparisonImpl();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an ID score to search (or 'exit' to quit): ");
            String input = scanner.nextLine();
            int id = Integer.parseInt(input);
            searchComparison.searchWithId(Integer.parseInt(input));

        }}

          // searchComparison.displaySortedList();;
            //searchComparison.searchWithName("Alic");

//            searchComparison.searchWithId(3);







