public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0; //use when the most significant digit is 9.
        for (int i = 0; i < digits.length; i++) {
            if (digits[digits.length - 1 - i] == 9) {
                carry = 1;
                digits[digits.length - 1 - i] = 0;
            }
            else {
                digits[digits.length - 1 - i] += 1;
                return digits;
            }
        }
        if (carry == 1) {
           digits = new int[digits.length+1];// assign a new value, no need to redefine.
           digits[0] = 1;
        }
        return digits;
    }
}