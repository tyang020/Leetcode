public class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", ""); // '\\s' the regexp of whitespace, '+' means one or more.
        int len = s.length();
        int res = 0;
        long sub = 0;
        char sign = '+';
        int i = 0;
        while (i < len) {
            long num = 0;
            while (i < len && Character.isDigit(s.charAt(i))) {
                num = num*10 + (s.charAt(i) - '0');
                i++;
            }
            // When encounter '+' or '-' add sub to res;
            // Else calculate sub;
            if (sign == '+') {
                res += sub;
                sub = num;
            } else if (sign == '-') {
                res += sub;
                sub = -num;
            } else if (sign == '*') {
                sub *= num;
            } else if (sign == '/') {
                sub /= num;
            }
            if (i < len) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += sub;
        return res;
    }
}