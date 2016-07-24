public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        //using binary search
        int low = 1, high = x;
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