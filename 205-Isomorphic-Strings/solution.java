public class Solution {
    public boolean isIsomorphic(String s, String t) {
        //acsii code 0-255
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0) {
                count[s.charAt(i)] = t.charAt(i) + 1;
            } else if (count[s.charAt(i) - 'a'] != t.charAt(i) + 1)
                return false;
        }
        return true;
    }
}