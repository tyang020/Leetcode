public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;      //When left is smaller than right, the areas between between left and those on the left of right 
                             //is at most (right-left)*left. So the max area would be on the right of current left
            else
                right--;
        }
        
        return maxArea;
    }
}