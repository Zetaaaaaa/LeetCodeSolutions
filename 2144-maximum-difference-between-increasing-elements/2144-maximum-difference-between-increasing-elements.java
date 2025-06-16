class Solution {
    public int maximumDifference(int[] nums) {
        int diff = -1;
        int minn = nums[0];
        for(int i = 1;i < nums.length; i++){
            if(nums[i] > minn){
                diff = Math.max(diff, nums[i] - minn);
            }
            if(nums[i] < minn){
                minn = nums[i];
            }
        }
        return diff;
    }
}