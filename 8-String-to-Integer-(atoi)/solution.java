public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() < 1) return 0;
        int i = 0;
        double res = 0;
        char sign = '+';
        //remove all whitespace
        str = str.trim();
        /*       
        while (i < str.length() && !isNumber(str.charAt(i))) {
           sign = isSign(str.charAt(i)) ? str.charAt(i) : '.';
           i++;
        }
        */
        if(str.charAt(0) == '-'){
            sign = '-';
            i++;
        } else if (str.charAt(0) == '+') 
            i++;
            
        while (i < str.length() && isNumber(str.charAt(i))) {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        if (sign == '-') 
            res = -res;
            
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (res > Integer.MAX_VALUE) {
           return Integer.MAX_VALUE;
        } else
            return (int)res;
    }
    
    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}