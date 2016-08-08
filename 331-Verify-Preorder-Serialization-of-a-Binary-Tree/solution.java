public class Solution {
    public boolean isValidSerialization(String preorder) {
        // Each non-null node has two outdegree and one indegree(2 children and 1 parent), except root.
        // Traverse each node, abstract 1 indegree, if it is not null, add 2 outdegree; The sum of indegree should be equal to the sum of outdegree
        String[] str = preorder.split(",");
        int degree = 1;
        for (String s : str) {
            if (--degree < 0)
                return false; // indegree
            if(!s.equals("#"))
                degree += 2; //outdegree
        }
        return degree == 0;
    }
}