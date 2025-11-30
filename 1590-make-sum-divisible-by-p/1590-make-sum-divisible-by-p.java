class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum = (sum + num) % p;
        int rem = sum % p;
        if (rem == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long totalSum = 0;
        int minLen = n;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            int currentMod = (int) (totalSum % p);
            int targetMod = (currentMod - rem + p) % p;
            if (map.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - map.get(targetMod));
            }
            map.put(currentMod, i);
        }
        return minLen == n ? -1 : minLen;
    }
}