package datastructures.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void test_push() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        assertEquals(1, stack.peek(), "Top of the stack should be 1");
    }

    @Test
    void test_pop() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop(), "Popped element should be 2");
        assertEquals(1, stack.peek(), "Top of the stack should be 1 after pop");
    }

    @Test
    void test_peek() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        assertEquals(1, stack.peek(), "Top of the stack should be 1");
        stack.push(2);
        assertEquals(2, stack.peek(), "Top of the stack should be 2");
    }

    @Test
    void test_isEmpty() {
        Stack<Integer> stack = new Stack<>(5);
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
        stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
    }

    // // This test case is not valid anymore as I wrote the logic to resize the
    // // stack when it is full
    // @Test
    // void test_push_throwsExceptionWhenStackIsFull() {
    //     Stack<Integer> stack = new Stack<>(2);
    //     stack.push(1);
    //     stack.push(2);
    //     StackOverflowError exception = assertThrows(StackOverflowError.class, () -> {
    //         stack.push(3);
    //     });
    //     assertEquals("Stack is full", exception.getMessage());
    // }

    @Test
    void test_pop_throwsExceptionWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>(2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void test_peek_throwsExceptionWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>(2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }
}
