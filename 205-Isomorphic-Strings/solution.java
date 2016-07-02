public class Solution {
    public boolean isIsomorphic(String s, String t) {
        //acsii code 0-255
        int[] s_to_t = new int[256];
        int[] t_to_s = new int[256];
        //the same char in s can't be replaced with diff char in t; 
        //And diff char in s cant be repelaced with the same char in t
        for (int i = 0; i < s.length(); i++) {
            if (s_to_t[s.charAt(i)] == 0 && t_to_s[t.charAt(i)] == 0) {
                s_to_t[s.charAt(i)] = t.charAt(i);
                t_to_s[t.charAt(i)] = s.charAt(i);
            } else if (s_to_t[s.charAt(i)] != t.charAt(i) || t_to_s[t.charAt(i)] != s.charAt(i))
                return false;
        }
        return true;
    }
}