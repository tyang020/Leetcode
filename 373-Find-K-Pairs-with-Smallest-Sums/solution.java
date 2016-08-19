public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> res = new ArrayList();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return res;
        
        PriorityQueue<Pair> pq = new PriorityQueue();
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new Pair(0, nums1[0], nums2[i]));
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Pair p = pq.poll();
            res.add(new int[]{p.n1, p.n2});
            if (i == nums1.length - 1) continue;
            pq.offer(new Pair(p.idx+1, nums1[p.idx+1], p.n2));
        }
        return res;
    }
}
class Pair implements Comparable<Pair> {
    int idx, n1, n2, sum;
    public Pair(int idx, int n1, int n2) {
        this.idx = idx;
        this.n1 = n1;
        this.n2 = n2;
        this.sum = this.n1 + this.n2;
    }
    
    @Override
    public int compareTo(Pair p) {
        return this.sum - p.sum;
    }
}