import java.math.BigInteger;   // avoid overflow
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = i+1; Math.max(i, j-i) <= num.length() - j; j++) {
                if (num.charAt(i) == '0' && j-i > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, j));
                if (isValid(x1, x2, num.substring(j)))
                    return true;
            }
        }
        return false;
    }
    
    private boolean isValid(BigInteger x1, BigInteger x2, String num) {
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        if (sum.equals(num))
            return true;
        if (sum.length() >= num.length() || !num.startsWith(sum))
            return false;
        return isValid(x1, x2, num.substring(sum.length()));
    }
}