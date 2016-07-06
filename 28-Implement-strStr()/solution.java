public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length()==0 && needle.length()==0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length())
                return -1;
            int k = i, j = 0;
            while (k < haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }
}