package datastructures.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoStacksTest {

    @Test
    void test_push1() {
        TwoStacks<Integer> stacks = new TwoStacks<>(10);
        stacks.push1(1);
        assertEquals(stacks.peak1(), 1, "Top of Stack1 should be 1");
    }

    @Test
    void test_push2() {
        TwoStacks<Integer> stacks = new TwoStacks<>(10);
        stacks.push2(1);
        assertEquals(stacks.peak2(), 1, "Top of Stack2 should be 1");
    }

    @Test
    void test_pop1() {
        TwoStacks<Integer> stacks = new TwoStacks<>(10);
        stacks.push1(1);
        int value = stacks.pop1();
        assertEquals(1, value, "Popped value from Stack1 should be 1");
    }

    @Test
    void test_pop2() {
        TwoStacks<Integer> stacks = new TwoStacks<>(10);
        stacks.push2(1);
        int value = stacks.pop2();
        assertEquals(1, value, "Popped value from Stack2 should be 1");
    }
}