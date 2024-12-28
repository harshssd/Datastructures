package datastructures.linkedlist;

public class DoublyLinkedList<T> {

    public class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
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
        newNode.prev = current;
        current.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        size++;
    }

    public boolean find(T key) {
        Node current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }
        return current != null;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = tail.prev;
            current.next = null;
            tail = current;
        }
        size--;
    }

    public boolean deleteByValue(T key) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return false;
        }

        if (head.data.equals(key)) {
            deleteAtHead();
            return true;
        }

        Node current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the list!");
            return false;
        }

        if (current == tail) {
            deleteAtTail();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
