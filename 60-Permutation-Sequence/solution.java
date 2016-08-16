public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        int[] fact = new int[n+1];
        fact[0] = 1;
        k--;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            fact[i] = sum;
        }
        
        
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j <= n; j++) 
            list.add(j);
        
        
        for (int i = 1; i <= n; i++) {
            int idx = k / fact[n-i];
            sb.append(list.get(idx));
            list.remove(idx);
            // next k
            k %= fact[n-i];
        }
        
        return sb.toString();
    }
    
}