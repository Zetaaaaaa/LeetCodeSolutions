class Solution {
    public int numOfWays(int n) {
        long[][] dp = new long[n][2];
        dp[0][0] = 2*3;
        dp[0][1] = 3*2;
        for(int i = 1; i < n; i++){
            dp[i][0] = (dp[i-1][0]*3 + dp[i-1][1]*2)%(1000000000 + 7);
            dp[i][1] = (dp[i-1][0]*2 + dp[i-1][1]*2)%(1000000000 + 7);
            
        }
        return (int)(dp[n-1][0] + dp[n-1][1]) % (1000000000 + 7);
    }
}