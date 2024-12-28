package datastructures.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void test_enqueue() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(1);
        assertEquals(1, queue.top(), "Front of the queue should be 1");
    }

    @Test
    void test_dequeue() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue(), "Dequeued element should be 1");
        assertEquals(2, queue.top(), "Front of the queue should be 2 after dequeue");
    }

    @Test
    void test_peek() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(1);
        assertEquals(1, queue.top(), "Front of the queue should be 1");
        queue.enqueue(2);
        assertEquals(1, queue.top(), "Front of the queue should still be 1");
    }

    @Test
    void test_isEmpty() {
        Queue<Integer> queue = new Queue<>(5);
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    }

    @Test
    void test_isFull() {
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(1);
        queue.enqueue(2);
        assertTrue(queue.isFull(), "Queue should be full");
    }

    // Wrote the logic to resize the queue when it is full, so this test case is not
    // valid anymore
    // @Test
    // void test_enqueue_throwsExceptionWhenQueueIsFull() {
    //     Queue<Integer> queue = new Queue<>(2);
    //     queue.enqueue(1);
    //     queue.enqueue(2);
    //     Exception exception = assertThrows(RuntimeException.class, () -> {
    //         queue.enqueue(3);
    //     });
    //     assertEquals("Queue is full", exception.getMessage());
    // }

    @Test
    void test_enqueue_resizesWhenQueueIsFull() {
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); // This should trigger a resize
        assertEquals(1, queue.dequeue(), "Dequeued element should be 1 after resize");
        assertEquals(2, queue.dequeue(), "Dequeued element should be 2 after resize");
        assertEquals(3, queue.top(), "Front of the queue should be 3 after resize");
    }

    @Test
    void test_dequeue_throwsExceptionWhenQueueIsEmpty() {
        Queue<Integer> queue = new Queue<>(2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.dequeue();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void test_peek_throwsExceptionWhenQueueIsEmpty() {
        Queue<Integer> queue = new Queue<>(2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.top();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }
}
