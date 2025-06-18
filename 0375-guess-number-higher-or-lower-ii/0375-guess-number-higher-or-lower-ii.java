class Solution {
    int solve(int l, int r, int[][] dp){
        if(l == r) return dp[l][r] = 0;
        if(dp[l][r] != -1) return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            ans = Math.min(ans, i + Math.max(solve(l, Math.max(l, i - 1), dp), solve(Math.min(i + 1, r), r, dp)));
        }
        return dp[l][r] = ans;
    }
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(var d: dp) Arrays.fill(d, -1);
        return solve(1, n, dp);
    }
}