class MyCircularQueue {
    int[] queue;
    int front = 0;
    int rear = -1;
    int len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        len++;
        rear++;
        rear %= queue.length;
        queue[rear] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front ++;
        front %= queue.length;
        len--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */