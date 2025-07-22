class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return (sum - min * nums.length);
    }
}