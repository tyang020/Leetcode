public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Ascii code of A: 0x
        Set<Integer> set = new HashSet();
        Set<String> res = new HashSet();
        int seq = 0;   // each letter uses 3 bit of seq and total is 30 bit which is smaller than 32
        for (int i = 0; i < 9 && i < s.length(); i++)
            seq = (seq << 3) | (s.charAt(i) & 7);
        for (int i = 9; i < s.length(); i++) {
            seq = (seq << 3 & 0x3FFFFFFF) | (s.charAt(i) & 7);
            if (!set.add(seq))
                res.add(s.substring(i-9, i+1));
        }
        return new ArrayList(res);
    }
}