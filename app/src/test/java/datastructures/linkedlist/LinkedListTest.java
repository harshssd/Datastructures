package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void test_isEmpty() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty(), "Should return true if the linked list is empty");
    }

    @Test
    void test_insertAtHead() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(2);
        assertEquals(linkedList.size, 2, "Should return exact size of the linked list");
    }

    @Test
    void test_insertAtTail() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(2);
        assertEquals(linkedList.size, 2, "Should return exact size of the linked list");
    }

    @Test
    void test_insertAfter() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtTail(3);
        linkedList.insertAtHead(1);
        linkedList.insertAfter(1, 2);
        assertEquals(linkedList.size, 3, "Should return exact size of the linked list");
    }

    @Test
    void test_find() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtTail(3);
        linkedList.insertAtHead(1);
        linkedList.insertAfter(1, 2);
        assertTrue(linkedList.find(2), "Should return true if the element is found in the linked list");
        assertFalse(linkedList.find(4), "Should return false if the element is not found in the linked list");
    }

    @Test
    void test_deleteAtHead() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtTail(3);
        linkedList.insertAtHead(1);
        linkedList.insertAfter(1, 2);
        assertEquals(linkedList.size, 3, "Should return exact size of the linked list before deletion");
        linkedList.deleteAtHead();
        assertFalse(linkedList.find(1), "Should return false if the deleted element is not found in the linked list");
        assertEquals(linkedList.size, 2, "Should return exact size of the linked list after deletion");
    }

    @Test
    void test_deleteByValue() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtHead(1);
        assertEquals(linkedList.size, 1, "Should return exact size of the linked list before deletion");
        linkedList.deleteByValue(1);
        assertFalse(linkedList.find(1), "Should return false if the deleted element is not found in the linked list");
        assertTrue(linkedList.isEmpty(), "Should return true if the linked list is empty after deletion");

        linkedList.insertAtTail(3);
        linkedList.insertAtHead(1);
        linkedList.insertAfter(1, 2);
        assertEquals(linkedList.size, 3, "Should return exact size of the linked list before deletion");
        linkedList.deleteByValue(2);
        assertFalse(linkedList.find(2), "Should return false if the deleted element is not found in the linked list");
        assertEquals(linkedList.size, 2, "Should return exact size of the linked list after deletion");
    }
}
