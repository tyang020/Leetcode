public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses]; // adjacent list
        // initialization
        for (int i = 0; i < numCourses; i++) 
            adj[i] = new ArrayList<Integer>();
        
        // Add edges into graph
        for (int i = 0; i < prerequisites.length; i++) 
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
            
        boolean[] visited = new boolean[numCourses], recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (hasCycle(i, adj, visited, recStack))
                return false;
        return true;
    }
    
    // Start from a vertex and check if there is cycle starting from this vertex
    private boolean hasCycle(int course, List<Integer>[] adj, boolean[] visited, boolean[] recStack) {
        if (recStack[course])   // when course in recursion stack, it must have been visited
            return true;
        else if (visited[course])
            return false;
        
        // when not visited and not in recursion stack:
        visited[course] = true;
        recStack[course] = true;  // Add course(current vertex) into recursion stack;
        for (int i = 0; i < adj[course].size(); i++) {
            if (hasCycle(adj[course].get(i), adj, visited, recStack))
                return true;
        }
        recStack[course] = false;
        return false;
        
    }
}