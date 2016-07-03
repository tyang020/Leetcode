public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        
        while (--n > 0) {
            StringBuilder res = new StringBuilder();
            int count = 0;
            char num = '.';
            for (char c : s.toCharArray()) {
                if (c == num) {
                    count++;
                } else {
                    if (count != 0)
                        res.append(count).append(num);
                    num = c;
                    count = 1;
                }
            }
            res.append(count).append(num);
            s = res.toString();
        }
        return s;
    }
}