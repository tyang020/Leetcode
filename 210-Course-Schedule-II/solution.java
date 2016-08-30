public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numOfPres = new int[numCourses];
        int[] order = new int[numCourses];
        // - Adjacency list, we don't have to modify once initialize it
        List<List<Integer>> adj = new ArrayList(numCourses);
        for (int i = 0; i < numCourses; i++) 
            adj.add(new ArrayList());
        for (int[] edge : prerequisites) {
            numOfPres[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
        // Add all the courses which have no pres into queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (numOfPres[i] == 0)
                queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int curPre = queue.poll();
            order[visited++] = curPre;
            for (int i : adj.get(curPre)) {
                if (--numOfPres[i] == 0)
                    queue.offer(i);
            }
        }
        return visited == numCourses ? order : new int[0];
    }
}