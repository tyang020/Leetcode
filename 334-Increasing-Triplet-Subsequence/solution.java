public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // n1 stores the smallest value so far, n2 stores the second value of the sequence
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= n1)
                n1 = n;
            else if (n <= n2) {
                n2 = n;
            }
            else
                return true;
        }
        return false;
    }
}