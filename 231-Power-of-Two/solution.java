public class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if (n < 1)  return false;
        return (n & n - 1) == 0;
        /*
        for(int i = 0; i < 32; i++){  
            if ((n & 1) == 1) count++;
            if (count > 1) return false;
            n >>= 1;
        }
        return count == 1;
        */
    }
}