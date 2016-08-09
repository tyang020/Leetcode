public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // For the rightmost '1' in n, it will get to be '0' when and with its previous number;
        // And for all '0's behind the rightmost one, it will be definitely zero in the result of this bit;
        // So we need to change all '1's behind the leftmost common bits of m and n to be '0's.
        while (m < n)
            n = n & (n-1); // remove rightmost '1';
        return n;
    }
}