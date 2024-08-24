class Solution {
    int[] dp = new int[46]; 
    public int climbStairs(int n) {
        if(n<=0)    return 0;
        if(n ==1 || n == 2|| n==3)  return n;
        if(dp[n] != 0)  return dp[n];

        int ways = climbStairs(n-1) + climbStairs(n-2);
        dp[n] = ways;

        return ways;
    }
}