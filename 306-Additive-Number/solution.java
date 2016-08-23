import java.math.BigInteger;   // avoid overflow
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = i+1; Math.max(i, j-i) <= num.length() - j; j++) {
                if (num.charAt(i) == '0' && j-i > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, j));
                if (isValid(x1, x2, int j, num))
                    return true;
            }
        }
        return false;
    }
    
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}