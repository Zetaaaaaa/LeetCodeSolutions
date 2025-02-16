class Solution {

    public boolean helper(int[] res, int[] nums, int idx){
        while(idx < res.length && res[idx] != 0)idx++;

        if(idx == res.length)
            return true;

        for(int i=nums.length-1; i>=1; i--){
            if(nums[i] == 0 && i == 1 && res[idx] == 0){
                nums[i] = i;
                res[idx] = i;
                if(helper(res, nums, idx+1))return true;
                nums[i] = 0;
                res[idx] = 0;
            }
            else if(nums[i] == 0 && idx+i < res.length && res[idx+i] == 0){
                nums[i] = 1;
                res[idx] = i; res[idx+i] = i;
                if(helper(res, nums, idx+1))return true;
                nums[i] = 0;
                res[idx] = 0; res[idx+i] = 0;
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        int[] nums =  new int[n+1];
        helper(res, nums, 0);
        return res;
    }
}