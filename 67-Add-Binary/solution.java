public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        String res = new String();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            //convert char to int
            int digit_a = i < 0 ? 0 : a.charAt(i--) - '0';
            int digit_b = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = digit_a + digit_b + carry;
            //use % and / to get sum and carry
            res = Integer.toString(sum % 2) + res;
            carry = sum / 2;
        }
        if (carry == 1) 
            res = Integer.toString(carry) + res;
        return res;
    }
}