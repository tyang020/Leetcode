public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if (nums == null || k <= 0)
            return new int[0];
         Deque<Integer> dq = new ArrayDeque<Integer>();  // store the indices in current window with all values larger than current number
         int len = nums.length;
         int[] res = new int[len-k+1];
         int ri = 0;
         
         for (int i = 0; i < len; i++) {
             
             // remove the first index which is out of window
             if (!dq.isEmpty() && dq.peek() < i-k+1)
                dq.poll();
                
            // remove all the indices that the values are smaller than nums[i], dq is a decreasing sequence
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            
            dq.offer(i);
            
            if (i >= k-1)
                res[ri++] = nums[dq.peek()];
         }
         return res;
         
    }
}