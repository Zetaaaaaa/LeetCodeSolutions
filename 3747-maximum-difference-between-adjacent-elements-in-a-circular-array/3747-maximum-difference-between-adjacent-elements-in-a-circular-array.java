class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int l = nums.length;
        int diff = Math.abs(nums[0] - nums[l-1]);
        for(int i = 0; i < l-1; i++){
            int d = Math.abs(nums[i] - nums[i+1]);
            if(d > diff)    diff = d;
        }
        return diff;
    }
}