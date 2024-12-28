package datastructures.linkedlist;

public class LinkedList<T> {

    public class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtTail(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void insertAfter(T key, T data) {
        Node current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the list!");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean find(T key) {
        Node current = head;
        int index = 0;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Key not found in the list!");
            return false;
        }

        System.out.println("Key found at index : " + index);
        return true;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        head = head.next;
        size--;
    }

    public boolean deleteByValue(T key) {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return false;
        }

        if (head.data.equals(key)) {
            deleteAtHead();
            return true;
        }

        Node current = head;
        Node prev = null;
        while (current != null && !current.data.equals(key)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the list!");
            return false;
        }

        if (prev != null) {
            prev.next = current.next;
            size--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data.toString() + " -> null");
    }
}
