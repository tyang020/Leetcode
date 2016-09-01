public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList();
        for (String[] s : tickets) {
            if (!map.containsKey(s[0]))
                map.put(s[0], new PriorityQueue<String>());
            map.get(s[0]).add(s[1]);
        } 
        
        Stack<String> stack = new Stack();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            res.add(0, stack.pop());
        }
        return res;
    }
}