public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        int i = 0, start = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') i++;
            start = i;
            while (i < path.length() && path.charAt(i) != '/') i++;
            String s = path.substring(start, i);
            if (s.equals("..") && !stack.isEmpty()) 
                stack.pop(); 
            else if (!s.equals(".") && !s.equals("..") && s.length() != 0) 
                stack.push(s);
        }
        if (stack.isEmpty())
            return "/";
        String res = "";
        while (!stack.isEmpty()) 
            res = "/" + stack.pop() + res;
        return res;
    }
}