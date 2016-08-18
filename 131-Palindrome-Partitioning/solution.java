public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> list, String s, int left) {
        if (left == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
            
        for (int right = left; right < s.length(); right++) {
            if (!isPalindrome(s, left, right)) continue;
            list.add(s.substring(left, right+1));
            helper(res, list, s, right + 1);
            list.remove(list.size()-1);
        }
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}