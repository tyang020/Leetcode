public class Solution {
    public int myAtoi(String str) {
       if(str == null) return 0;
       int i = 0;
       long res = 0;
       while (i < str.length() && !isNumber(str.charAt(i))) {
           i++;
       }
       while (i < str.length() && isNumber(str.charAt(i))) {
           res = res * 10 + str.charAt(i) - '0';
       }
       if (res < Integer.MIN_VALUE) {
           return Integer.MIN_VALUE;
       } else if (res > Integer.MAX_VALUE) {
           return Integer.MAX_VALUE;
       } else
            return (int)res;
    }
    private static boolean isNumber(char c) {
        if (c == '+' || c == '-' || (c > '0' && c < '9'))
            return true;
        else
            return false;
    }
}