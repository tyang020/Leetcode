public class MinStack {
    /** Save the difference between number and min instead of save the original number */
    private double min;
    private Stack<Double> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0.0);
            min = x;
        } else {
            stack.push(x - min); //when min changes, push a negative number
            if (x < min) min = x; 
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        double pop = stack.pop();
        if (pop < 0) min = min - pop; // if negative, increase min value;
    }
    
    public int top() {
        if (stack.peek() <= 0)
            return (int)min;
        else
            return (int)(stack.peek() + min);
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */