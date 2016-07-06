public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 0) return "";
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int mod = i % (numRows * 2 - 2);
            if (mod < numRows) 
                sbs[mod].append(s.charAt(i));
            else
                sbs[numRows - 2 - mod % numRows].append(s.charAt(i));
        }
        for (int i = 1; i < numRows; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}