class Solution {
    public int longestSubarray(int[] nums) {
        int j = -1;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != maxVal) {
                j = i;
            }
            res = Math.max(res, i - j);
        }

        return res;
    }
}