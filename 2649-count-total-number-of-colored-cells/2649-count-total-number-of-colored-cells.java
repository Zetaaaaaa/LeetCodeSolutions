class Solution {
    public long coloredCells(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        long t = 4;
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1] + t;
            t += 4;
        }
        return dp[n-1];
    }
}