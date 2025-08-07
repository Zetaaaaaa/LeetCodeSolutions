class Solution {
    int max(int a, int b) {
        return a > b ? a : b;
    }
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];
        dp[0][n-1] = fruits[0][n-1];
        for(int i=0; i<n-1; i++){
            dp[0][i] = -99999999;
        }
        for(int i=1; i<n-1; i++){
            for(int j=n-i-1; j<n; j++){
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]);
                if(j < n-1){
                    dp[i][j] = max(dp[i-1][j+1], dp[i][j]);
                }
                dp[i][j] += fruits[i][j];
            }
        }
        int ret = dp[n-2][n-1];
       dp[n-1][0] = fruits[n-1][0];
        for(int i=0; i<n-1; i++){
            dp[i][0] = -99999999;
        }
        for(int i=1; i<n-1; i++){
            for(int j=n-i-1; j<n; j++){
                dp[j][i] = max(dp[j][i-1], dp[j-1][i-1]);
                if(j < n-1) {
                    dp[j][i] = max(dp[j+1][i-1], dp[j][i]);
                }
                dp[j][i] += fruits[j][i];
            }
        }        
        ret += dp[n-1][n-2];
        for(int i=0; i<n; i++){
            ret += fruits[i][i];
        }
        return ret;
    }
    
}