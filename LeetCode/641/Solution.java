class MyCircularDeque {
    int[] queue;
    int start;
    int end;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        queue = new int[k];    
        Arrays.fill(queue, -1);
        size = 0;
        capacity = k;
        start = 0;
        end = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        if(start == 0) {
            start = capacity - 1;
        } else {
            start--;
        }
        queue[start] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        queue[end] = value;
        if(end == capacity-1) {
            end = 0;
        } else {
            end++;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        queue[start] = -1;
        if(start == capacity-1) {
            start = 0;
        } else {
            start++;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        if(end == 0) {
            end = capacity-1;
        } else {
            end--;
        }
        queue[end] = -1;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return queue[start];
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        if(end == 0) {
            return queue[capacity-1];
        } else {
            return queue[end-1];
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return capacity == size;
    }
}
