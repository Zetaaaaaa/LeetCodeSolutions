class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);

            if (absValue < minDistance || (absValue == minDistance && absValue > closest)) {
                closest = nums[i];
                minDistance = absValue;
            }
        }  

        return closest; 
    }
}