package datastructures.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void test_push() {
        MinStack stack = new MinStack(10);
        stack.push(5);
        assertEquals(5, stack.peek(), "Top of the stack should be 5");
    }

    @Test
    void test_pop() {
        MinStack stack = new MinStack(10);
        stack.push(5);
        stack.push(3);
        stack.pop();
        assertEquals(5, stack.peek(), "Top of the stack should be 5 after popping 3");
    }

    @Test
    void test_top() {
        MinStack stack = new MinStack(10);
        stack.push(5);
        stack.push(3);
        assertEquals(3, stack.peek(), "Top of the stack should be 3");
    }

    @Test
    void test_getMin() {
        MinStack stack = new MinStack(10);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        assertEquals(3, stack.getMin(), "Minimum value in the stack should be 3");
        stack.pop();
        assertEquals(3, stack.getMin(), "Minimum value in the stack should still be 3 after popping 7");
        stack.pop();
        assertEquals(5, stack.getMin(), "Minimum value in the stack should be 5 after popping 3");
    }
}