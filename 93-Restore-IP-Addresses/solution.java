public class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        int len = s.length();
        if (len < 4)
            return res;
        for (int i = 1; i <= 3 && i < len-2; i++) {
            String s1 = s.substring(0, i);
            if (!isValid(s1)) break;
            for (int j = i + 1; j - i <= 3 && j < len - 1; j++) {
                String s2 = s.substring(i,j);
                if (!isValid(s2)) break;
                for (int k = j + 1; k - j <= 3 && k < len; k++) {
                    String s3 = s.substring(j, k), s4 = s.substring(k);
                    if (!isValid(s3)) break;
                    if (!isValid(s4)) continue;
                    res.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        if ((s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255)
            return false;
        return true;
    }
}