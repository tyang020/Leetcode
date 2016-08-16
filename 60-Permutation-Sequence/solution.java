public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
       
        int factorial = 1, i = 1;
        k--;
        while(factorial < k) {
            i++;
            factorial *= i;
        }
        
        // The first n-i numbers should in order
        for (int num = 1; num <= n - i; num++) {
            sb.append(String.valueOf(num));
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for (int j = n-i+1; j <= n; j++) 
            list.add(j);
        
        // Find the largest factorial which is smaller than k
        
        while (!list.isEmpty()) {
            factorial /= i--;
            int idx = k / factorial;
            sb.append(String.valueOf(list.get(idx)));
            list.remove(idx);
            k %= factorial;
        }
        
        return sb.toString();
    }
    
}