public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length()+1];  // denote whether it is breakable before index i(exclusive)
        breakable[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}