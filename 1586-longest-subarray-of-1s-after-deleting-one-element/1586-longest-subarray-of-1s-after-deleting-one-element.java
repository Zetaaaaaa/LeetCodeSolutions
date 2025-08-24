class Solution {
    public int longestSubarray(int[] nums) {
        int wstart = 0;
        int res = 0;
        int k = 0;
        for (int wend = 0; wend < nums.length; wend ++) {
            if (nums[wend] == 0) {
                k += 1;
            }
            while (k > 1) {
                if (nums[wstart] == 0) {
                    k -= 1;
                }
                wstart += 1;
            }
            int t = (k==0)?1:k;
            res = Math.max(res, wend-wstart+1-t);
        }
        return res;
    }
}