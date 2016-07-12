public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //map: count the frequency of each number
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n,0);
            else
                map.put(n, map.get(n) + 1);
        }
        // frequency of each element is from 0 to nums.length
        // each bucket saves a list of numbers with the same frequency
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key : map.keySet()) {
            int fq = map.get(key);
            if(bucket[fq] == null) {
                bucket[fq] = new ArrayList();
            }
            bucket[fq].add(key);
        }
        
        //get the results:
        List<Integer> res = new ArrayList();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }
        return res;
    }
}