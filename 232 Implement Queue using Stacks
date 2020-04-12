//Approach #1 (Two Stacks) Push - O(n), O(n) per operation, Pop - O(1), O(1) per operation.

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();  
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

// Approach #2 (Two Stacks) Push - O(1)O(1) per operation, Pop - Amortized O(1)O(1) per operation

class MyQueue {
    int front;
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        front = 0;
        s1 = new Stack<>();
        s2 = new Stack<>();  
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        }
        return s2.pop();   
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
