public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //2 passes
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int backPro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= backPro;
            backPro *= nums[i];
        }
        return res;
    }
}