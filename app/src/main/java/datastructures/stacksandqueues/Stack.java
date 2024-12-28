package datastructures.stacksandqueues;

public class Stack<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int s) {
        maxSize = s;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    public void push(T data) {
        if (isFull()) {
            resize();
        }
        stackArray[++top] = data;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[stackArray.length * 2];
        System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
        stackArray = newArray;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stackArray[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return top == stackArray.length - 1;
    }
}
