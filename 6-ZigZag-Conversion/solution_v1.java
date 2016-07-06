public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) 
                sbs[j].append(s.charAt(i++));
            for (int j = numRows - 2; j > 0 && i < s.length(); j--)
                sbs[j] = append(s.charAt(i++));
        }
        for (int i = 1; i < numRows; i++) 
            sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }
}