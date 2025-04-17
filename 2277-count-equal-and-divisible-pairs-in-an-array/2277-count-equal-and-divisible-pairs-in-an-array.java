class Solution {
    public int countPairs(int[] nums, int k) {
        return getCount(nums, k, 0);
    }

    public int getCount(int[] nums, int k, int i){
        
        if(i >= nums.length) return 0;

        int res = 0;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i] == nums[j] && (i*j)%k == 0)
                res++;
        }

        return res+getCount(nums,k,i+1);
    }
}