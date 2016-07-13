public class Solution {
    public int maxProduct(String[] words) {
        /**
         * Pre-process each word to be represented by a 26-bit integer
         */
         int len = words.length;
         int[] value = new int[len];
         for (int i = 0; i < len; i++) {
             for (char c : words[i].toCharArray()) {
                 value[i] |= 1 << (c - 'a');
             }
         }
         int maxPro = 0;
         for (int i = 0; i < len; i++) {
             for (int j = i + 1; j < len; j++) {
                 if ((value[i] & value[j]) == 0 && words[i].length()*words[j].length() > maxPro )
                    maxPro = words[i].length()*words[j].length();
             }
         }
         return maxPro;
    }
}