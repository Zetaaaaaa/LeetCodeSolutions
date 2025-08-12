class Solution {
    private int[][] dp;
    private int x;

    public int numberOfWays(int n, int inputX) {
        x = inputX;
        dp = new int[n + 1][n + 2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[1][1] = 1;
        compute(n, 1);
        return dp[n][1];
    }

    // starting from k
    private int compute(int n, int k) {
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        if (n == 0) {
            return 1;
        }
        if (k > n) {
            dp[n][k] = 0;
            return dp[n][k];
        }
        if (k == n) {
            dp[n][k] = (x == 1 ? 1 : 0);
            return dp[n][k];
        }
        dp[n][k] = 0;
        int num = k;
        while (num <= n) {
            int tmp = 1;
            int pow = 0;
            for (pow = 0; pow < x; pow++) {
                tmp *= num;
                if (tmp > n) {
                    break;
                }
            }
            if (pow == x) {
                int cnt = compute(n - tmp, num + 1);
                dp[n][k] = (dp[n][k] + cnt) % 1000000007;
            }
            num++;
        }
        return dp[n][k];
    }
}