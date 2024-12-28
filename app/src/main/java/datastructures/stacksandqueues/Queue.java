package datastructures.stacksandqueues;

// Most operating systems also perform operations based on a Priority Queue—a kind of queue that allows operating 
// systems to switch between appropriate processes. 
// They are also used to store packets on routers in a certain order when a network is congested. 
// Implementing a cache also heavily relies on queues.
public class Queue<T> {
    private int maxSize;
    private T[] queueArray;
    private int front;
    private int back;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int s) {
        maxSize = s;
        queueArray = (T[]) new Object[maxSize];
        front = 0;
        back = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queueArray[front];
    }

    public void enqueue(T data) {
        if (isFull()) {
            resize();
        }
        if (back == maxSize - 1) {
            back = -1;
        }
        back++;
        queueArray[back] = data;
        size++;
    }

    private void resize() {
        int newMaxSize = maxSize * 2;
        @SuppressWarnings("unchecked")
        T[] newQueueArray = (T[]) new Object[newMaxSize];
        // Queue is a circular array, so we need to copy the elements from front to back
        for (int i = 0; i < size; i++) {
            newQueueArray[i] = queueArray[(front + i) % maxSize];
        }
        queueArray = newQueueArray;
        front = 0;
        back = size - 1;
        maxSize = newMaxSize;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return temp;
    }
}
