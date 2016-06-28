class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 1)
            q2.offer(q1.remove());
        q1.remove();
        while(!q2.isEmpty())
            q1.offer(q2.remove());
    }

    // Get the top element.
    public int top() {
        while(q1.size() > 1)
            q2.offer(q1.remove());
        int top = q1.peek();
        q2.offer(q1.remove());
        while(!q2.isEmpty())
            q1.offer(q2.remove());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty && q2.isEmpty();
    }
}