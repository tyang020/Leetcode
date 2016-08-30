public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Reference: https://discuss.leetcode.com/topic/30572/share-some-thoughts/2
        // Traverse from end node where its degree equals to 1, and after visited, remove it, update degree of all its neighbors and add nodes whose degree equals to 1, similar to BFS topological sort, until there are only one or two nodes
        
        if (n == 1) return new ArrayList<Integer>(Arrays.asList(0));
        
        // adjacency list initialization of graph
        Set<Integer>[] set = new HashSet[n];
        for (int i = 0; i < n; i++) set[i] = new HashSet();
        for (int[] edge : edges) {
            set[edge[0]].add(edge[1]);
            set[edge[1]].add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (set[i].size() == 1)
                leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> new_leaves = new ArrayList();
            for (int i : leaves) {
                for (int j : set[i]) {
                    set[j].remove(i);
                    if (set[j].size() == 1)
                        new_leaves.add(j);
                }
            }
            leaves = new_leaves;
        }
        return leaves;
    }
}