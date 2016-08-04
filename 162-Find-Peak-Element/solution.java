public class Solution {
    public int findPeakElement(int[] nums) {
        /** You can review how to find a local minimum in the following link:
         *  http://stackoverflow.com/questions/12238241/find-local-minima-in-an-array
         * 
         *  This problem is the same as finding a local maximum in an array.(local maximum: nums[i-1] < nums[i] > nums[i+1]).
         *  The main idea is: If there are multiple elements, look at the middle element. If it's local maximum, we are done.
         *  Otherwise, at least one of its neighbors is larger than it. Then move toward to the direction where the larger element is at.
         *  In this half of the array, all the elements are smaller or larger than its previous one. If they are getting larger, the last
         *  one would be the local maximum. Otherwise, there must be one element that is smaller than its previous one. Then the previous
         *  one would be the local maximum. 
         *  From the previous analysis, we are sure that we can find local maximum in the half which contains larger neighbor of middle.
         *  
         *  For an element nums[i], if nums[i-1] > nums[i], find peak element on left half. Else, find peak element on right half.
         */
         
         int left = 0, right = nums.length - 1;
         while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
                return mid;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else if (nums[mid] < nums[mid - 1]) 
                right = mid;
         }
         return left;
    }
}