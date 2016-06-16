public class Solution {
    public boolean isPowerOfFour(int num) {
    /*
     * 1. 0 is not
     * 2. If the number is power of four, the odd bits(suppose the least significant bit is 0) must be 0;
     * 3. If the number is power of four, there must be only one bit whose value is 1. This method  is from the book <<Hacker's Delight>>
     */
        return (num > 0) && (num & num - 1) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}