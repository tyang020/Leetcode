public class Solution {
    // Construct a graph using adjcency list
    private Map<String, PriorityQueue<String>> adj = new HashMap<>();
    private List<String> res = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        // Initialize graph
        for (String[] s : tickets) {
            if (!adj.containsKey(s[0]))
                adj.put(s[0], new PriorityQueue<String>());
            adj.get(s[0]).add(s[1]);
        }
        helper("JFK");
        return res;
    }
    private void helper(String from) {
        while (adj.containsKey(from) && !adj.get(from).isEmpty()) {
            helper(adj.get(from).poll());
        }
        res.add(0, from);
    }
}