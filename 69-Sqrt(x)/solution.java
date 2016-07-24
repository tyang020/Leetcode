public class Solution {
    public int mySqrt(int x) {
        //using binary search
        int low = 0, high = x / 2 + 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == x)
                return mid;
            if (mid * mid < x)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }
}