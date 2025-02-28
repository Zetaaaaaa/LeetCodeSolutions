class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j < m; j++)
            dp[n][j] = m - j;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = n - i;
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        while (i < n || j < m) {
            if (i < n && j < m && s.charAt(i) == t.charAt(j)) {
                res.append(s.charAt(i));
                i++; j++;
            } 
            else if (i < n && (j == m || dp[i + 1][j] <= dp[i][j + 1]))
                res.append(s.charAt(i++));
            else
                res.append(t.charAt(j++));
        }

        return res.toString();
    }
}