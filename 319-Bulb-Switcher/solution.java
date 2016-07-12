public class Solution {
    public int bulbSwitch(int n) {
        /** If a number i is a square number, it has odd number of factors, then after n round the ith bulb is on. 
         *  eg 9 has factors 1,3,9(on,off,on)
         *  
         *  Else it has even number of factors, i.e., 7 has 1 and 7, and 8 has 1,2,4,8, then the ith bulb is off after n round.
         */
        // just count the square numbers
        return sqrt(n);
        /*if (n == 0) return 0;
        int i;
        for (i = 1; i * i <= n; i++) {
            
        }
        return i-1;
        */
    }
}