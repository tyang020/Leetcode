public class Solution {
    public void nextPermutation(int[] nums) {
        // i.e: 126386532
        // 1. find 3 at index 3
        // 2. swap 3 at index 3 with 5 at index 6;
        // 3. reverse 86332 to 23386
        int i = 0, n = nums.length;
        if (n < 2)
            return;
        
        //find the first element which is smaller than its previous one from end to start
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        
        // when nums is already the largest permutation
        if (i == -1) {  
            reverseSort(nums, 0, n-1);
            return;
        }
        
        // when we find the first element which is smaller than its previous one from end to start,
        // swap this element with the smallest element  which is larger than it behind it, then reverse them behind this element
        // since those elements behind this element are in a descending order
        int min = nums[i];
        for (int j = n - 1; j > i; j--) {
            if (nums[j] > min) {
                swap(nums, i, j);
                break;
            }
        }
        reverseSort(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverseSort(int[] nums, int start, int end) {
        for (int i = start; i <= start+(end-start)/2; i++) {
            swap(nums, i, end-start+i);
        }
    }
}