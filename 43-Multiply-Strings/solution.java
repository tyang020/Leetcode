public class Solution {
    public String multiply(String num1, String num2) {
        // The length of the results would be no more than num1.length() + num2.length();
        
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        
        for (int i = len2 - 1; i >= 0; i--) {
            for (int j = len1 - 1; j >= 0; j--) {
                
                int sum = (num1.charAt(j) - '0') * (num2.charAt(i)-'0');
                sum += res[i+j+1]; // sum of this bit
                
                res[i+j+1] = sum%10;
                res[i+j] += sum/10; // total carryout
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n : res)
            if(!(n == 0 && sb.length() == 0))
                sb.append(n);
        return sb.length()==0 ? "0" : sb.toString();
    }
}