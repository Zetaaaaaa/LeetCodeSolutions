class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefix = 0;
        long sub = Long.MIN_VALUE;
        long[] minsofar = new long[k];
        Arrays.fill(minsofar, Long.MAX_VALUE / 2);
        minsofar[(k - 1) % k] = 0;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            sub = Math.max(sub, prefix - minsofar[i % k]);
            minsofar[i % k] = Math.min(minsofar[i % k], prefix);
        }
        return sub;
    }
}