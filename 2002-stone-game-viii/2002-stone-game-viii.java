class Solution {
    public int stoneGameVIII(int[] stones) {
        int[] dp = new int[stones.length-1];
        dp[0] = stones[0]+stones[1];
        for (int i=1; i<dp.length; i++)
            dp[i] = dp[i-1] + stones[i+1];
        int maxx = dp[dp.length-1];
        for (int i=dp.length-2; i>=0; i--)
            maxx = Math.max(maxx,dp[i]-maxx);
        
        return maxx;
    }
}