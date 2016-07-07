public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                //count += n % 2;
                //n = n / 2;
                count++;
                n = n&(n-1); //flip the least significant 1-bit to 0;
            }
            res[i] = count;
        }
        return res;
    }
}