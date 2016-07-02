public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        Map<Character, String> map = new HashMap();
        Set<String> set = new HashSet();
        for (int i = 0; i < word.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!set.add(word[i])) return false;
                map.put(pattern.charAt(i),word[i]);
            } else if (!map.get(pattern.charAt(i)).equals(word[i]))
                return false;
        }
        return true;
    }
}