class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long bp = (1L * n * (n-1))/2;
        long gp = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int prev = map.getOrDefault(i-nums[i],0);
            gp += prev;
            map.put(i-nums[i], prev + 1);
        }
        return bp - gp;
    }
}