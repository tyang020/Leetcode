public class Solution {
    public String simplifyPath(String path) {
        Set<String> skip = new HashSet(Arrays.asList("", ".", ".."));
        Stack<String> stack = new Stack();
        for (String dir : path.split("/+")) { // one or more slash represented by regexp
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!skip.contains(dir))
                stack.push(dir);
        }
        String res = "";
        while (!stack.isEmpty()) res = "/" + stack.pop() + res;
        return res == "" ? "/" : res;
    }
}