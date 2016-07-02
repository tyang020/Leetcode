public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)-'a'] == 0) {
                count[s.charAt(i) - 'a'] = t.charAt(i) - 'a' + 1;
            } else if (count[s.charAt(i) - 'a'] != t.charAt(i) - 'a' + 1)
                return false;
        }
        return true;
    }
}