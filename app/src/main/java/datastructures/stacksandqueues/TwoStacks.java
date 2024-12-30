package datastructures.stacksandqueues;

public class TwoStacks<T> {
    private int maxSize;
    private T[] stackArray;
    private int top1;
    private int top2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int s) {
        maxSize = s;
        stackArray = (T[]) new Object[maxSize];
        top1 = -1;
        top2 = maxSize;
    }

    public void push1(T data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        stackArray[++top1] = data;
    }

    public void push2(T data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        stackArray[--top2] = data;
    }

    private boolean isFull() {
        return top1 + 1 == top2;
    }

    public T pop1() {
        if (isEmpty1()) {
            throw new RuntimeException("Stack 1 is empty");
        }
        return stackArray[top1--];
    }

    private boolean isEmpty1() {
        return top1 == -1;
    }

    public T pop2() {
        if (isEmpty2()) {
            throw new RuntimeException("Stack 2 is empty");
        }
        return stackArray[top2++];
    }

    private boolean isEmpty2() {
        return top2 == maxSize;
    }

    public T peak1() {
        if (isEmpty1()) {
            throw new RuntimeException("Stack 1 is empty");
        }
        return stackArray[top1];
    }

    public T peak2() {
        if (isEmpty2()) {
            throw new RuntimeException("Stack 2 is empty");
        }
        return stackArray[top2];
    }
}
