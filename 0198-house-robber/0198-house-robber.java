class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int s = 0, val = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(nums[i] + s, val);
            s=val;
            val = res;
        }

        return res;
    }
}