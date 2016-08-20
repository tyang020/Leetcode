public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] > target)
                hi--;
            else if (numbers[lo] + numbers[hi] < target)
                lo++;
            else
                return new int[]{lo+1, hi+1};
        }
        return new int[]{0, 0};
    }
}