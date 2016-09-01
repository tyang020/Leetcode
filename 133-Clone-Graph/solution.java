/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();   // map stores node lables which are cloned and their cloned nodes.
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);  // clone label
        map.put(node.label, cloned);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));  // add each cloned neighbor to clone.neighbors
        }
        return cloned;
    }
}