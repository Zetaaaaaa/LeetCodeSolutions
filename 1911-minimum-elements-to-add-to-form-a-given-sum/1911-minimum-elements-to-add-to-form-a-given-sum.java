class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long s = 0;
        for(int i:nums)    s+=i;
        long d = Math.abs(s-goal);
        return (int) ((d/limit)+(d%limit==0?0:1));
    }
}