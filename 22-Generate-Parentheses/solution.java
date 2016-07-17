public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper(res, "", n, 0);
        return res;
    }
    // Count the number of open and close parenthesis
    public void helper(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (right > 0) helper(res, str + ")", left, right - 1);
        if (left > 0) helper(res, str + "(", left - 1, right + 1);
    }
}