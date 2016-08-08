public class Solution {
    public boolean isValidSerialization(String preorder) {
        // Using stack to save the nodes which have not finished traversal.
        Stack<String> stack = new Stack<String>();
        String[] str = preorder.split(",");
        for (String s : str) {
            while (!stack.isEmpty() && s.equals("#") && stack.peek().equals("#")) {
                stack.pop();   // Remove #
                if (stack.isEmpty())
                    return false;
                stack.pop();   // Remove number before "#". After removing the number, it might be a "#" in the top, so we should check again;
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}