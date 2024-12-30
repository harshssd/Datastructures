package datastructures.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueUsingStacksTest {

    @Test
    void test_enqueue() {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>(5);
        queue.enqueue(1);
        assertEquals(1, queue.peek(), "Front of the queue should be 1");
    }

    @Test
    void test_dequeue() {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        int value = queue.dequeue();
        assertEquals(1, value, "Dequeued value should be 1");
        assertEquals(2, queue.peek(), "Front of the queue should now be 2");
    }

    @Test
    void test_peek() {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek(), "Front of the queue should be 1");
    }

    @Test
    void test_isEmpty() {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>(5);
        assertTrue(queue.isEmpty(), "Queue should be empty");
        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty");
    }

}