/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        // We create a NestedInteger curr to record the current nested integer.
        // 1. If '[', add previous level of saved NestedInteger to stack and create a new level NestedInteger curr;
        // 2. If ',' or ']', it indicates the end of integer, add the recorded integer to curr;
        //    As for ']', it also indicates the end of NestedInteger at current level. We need to backtrack the previous level of NestedInteger popped from stack and add this curr to pop, then set curr to pop.
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.valueOf(s));
        
        NestedInteger curr = null;
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int l = 0;     // l keeps track of the start of an integer while r keeps track of the end.
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (c == '[') {
                if (curr != null)
                    stack.push(curr);
                curr = new NestedInteger();
                l = r + 1;
            } else if (c == ',') {
                if (s.charAt(r-1) != ']')
                    curr.add(new NestedInteger(Integer.valueOf(s.substring(l, r))));
                l = r + 1;
            } else if (c == ']') {
                if (l < r)
                    curr.add(new NestedInteger(Integer.valueOf(s.substring(l, r))));
                if (!stack.isEmpty()) {
                    NestedInteger prev = stack.pop();
                    prev.add(curr);
                    curr = prev;
                }
                l = r + 1;
            }
        }
        return curr;
    }
}