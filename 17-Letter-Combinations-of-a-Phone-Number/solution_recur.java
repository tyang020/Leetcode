public class Solution {
    
    private String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.isEmpty())
            return res;
        
        String str = new String();
        helperDfs(res, str, 0, digits);
        return res;
    }
    
    public void helperDfs(List<String> res, String str, int pos, String digits) {
        if (pos >= digits.length()) {
            res.add(str.toString());
            return;
        }
        
        String letters = map[digits.charAt(pos)-'0'];
        for (char c : letters.toCharArray()) {
            //str.append(c);
            helperDfs(res, str+c, pos + 1, digits);
            //str.deleteCharAt(str.length()-1);
        }
        
    }
        
}