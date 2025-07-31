class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n == 1)  return 1;
        double[] dp = new double[n];
        dp[0] = 1.0;
        dp[1] = 0.5;
        for(int i = 2; i < dp.length; i++){
            double res = (1/(1.0*n)) + ((n-2)/(1.0*n))*(dp[i-1]);
            dp[i] = res;
        }
        return dp[n-1];
    }
}