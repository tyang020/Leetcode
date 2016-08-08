public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        //if (n == 0 || citations[n-1] == 0)
        //    return 0;
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] == n-mid)
                return n-mid;
            if (citations[mid] < n-mid)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return n-lo;
        
        /*
        for (int i = 1; i < n; i++) {
            if (citations[n-i] >= i)
                return i;
        }
        return 0;
        */
    }
}