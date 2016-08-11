public class Solution {
    public List<String> letterCombinations(String digits) {
        // After each iteration, the length of each string is equal to iteration number
        
        List<String> res = new ArrayList();
        if (digits.length() == 0) return res;
        
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            String letters = map[digits.charAt(i)-'0'];
            
            // for all the strings get from last digit, whose length is i, remove them and add a letter mapping to current digit
            while (res.get(0).length() == i) {
                String top = res.remove(0);
                for (char c : letters.toCharArray())
                    res.add(top+c);
            }
        }
        
        return res;
    }
}