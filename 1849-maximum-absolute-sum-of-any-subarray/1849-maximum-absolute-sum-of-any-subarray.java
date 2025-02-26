class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int curr = 0, init = 0;
        for(int i : nums){
            curr += i;
            init += i;
            maxx = Math.max(curr, maxx);
            minn = Math.min(init, minn);
            if(curr < 0)    curr = 0;
            if(init > 0)    init = 0;
        }
        minn = Math.abs(minn);
        return Math.max(minn, maxx);
    }
    
}