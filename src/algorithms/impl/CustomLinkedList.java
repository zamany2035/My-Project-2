package algorithms.impl;

import java.util.LinkedList;

public class CustomLinkedList<S extends LinkedList<StudentRecord>> {
    Node head;

    class Node {
        StudentRecord data;
        Node next;

        Node(StudentRecord data) {
            this.data = data;
            this.next = null;
        }
    }
}
