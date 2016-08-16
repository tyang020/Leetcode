public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
       
        int factorial = 1, i = 1;
        k--;
        while(i < n) {
            i++;
            factorial *= i;
        }
        
        
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j <= n; j++) 
            list.add(j);
        
        // Find the largest factorial which is smaller than k
        factorial /= i--;
        
        while (i > 0) {
            int idx = k / factorial;
            sb.append(list.get(idx));
            list.remove(idx);
            k %= factorial;
            factorial /= i--;
        }
        sb.append(list.get(0));
        
        return sb.toString();
    }
    
}