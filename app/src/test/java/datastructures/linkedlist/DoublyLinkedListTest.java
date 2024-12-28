package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void test_isEmpty() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        assertTrue(linkedList.isEmpty(), "Should return true if the linked list is empty");
    }

    @Test
    void test_insertAtHead() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtHead(1);
        assertFalse(linkedList.isEmpty(), "Should return false if the linked list is not empty");
        assertEquals(1, linkedList.head.data, "Head should be 1");
    }

    @Test
    void test_insertAtTail() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        assertEquals(2, linkedList.tail.data, "Tail should be 2");
    }

    @Test
    void test_insertAfter() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAfter(1, 3);
        assertEquals(3, linkedList.head.next.data, "Node after head should be 3");
    }

    @Test
    void test_find() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        assertTrue(linkedList.find(2), "Should return true if the element is found");
        assertFalse(linkedList.find(3), "Should return false if the element is not found");
    }

    @Test
    void test_deleteAtHead() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.deleteAtHead();
        assertEquals(2, linkedList.head.data, "Head should be 2 after deletion");
    }

    @Test
    void test_deleteAtTail() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.deleteAtTail();
        assertEquals(1, linkedList.tail.data, "Tail should be 1 after deletion");
    }

    @Test
    void test_deleteByValue() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        assertTrue(linkedList.deleteByValue(2), "Should return true if the element is deleted");
        assertFalse(linkedList.find(2), "Should return false if the element is not found");
    }
}
