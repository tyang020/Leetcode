public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /** 1. Build a minHeap of elements from the first row.
         *  2. Do the following operations k-1 times :
         *     Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of 
         *     that elemen(so we can create a tuple class here), replace that root with the next element from the same column.
         */
        PriorityQueue<Tuple> pq= new PriorityQueue<Tuple>();
        // add the first row to pq
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue; // when we come to last row
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
}