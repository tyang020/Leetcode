public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.empty() || Math.abs(c - stack.pop()) > 2)
                return false;
        }
        return stack.empty();
    }
}