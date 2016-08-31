public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len+1];
        dp[len] = 1;
        dp[len-1] = s.charAt(len-1) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i) == '0')
                continue;
            if (Integer.valueOf(s.substring(i,i+2)) <= 26)
                dp[i] = dp[i+1] + dp[i+2];
            else
                dp[i] = dp[i+1];
        }
        return dp[0];
    }
}