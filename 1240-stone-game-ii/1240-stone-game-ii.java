class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = piles[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+piles[i];
        }

        int[][] dp = new int[n][n];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        int cnt = count(piles, 0, 1,prefixSum,dp);
        return cnt;
    }

    int count(int[] piles, int i, int M,int[] prefixSum,int[][] dp){
        int n = piles.length;
        
        if(i>n-1)return 0;
        if(n-i<=2*M)return prefixSum[n-1]-((i==0)?0:prefixSum[i-1]);

        if(dp[i][M]!=-1) return dp[i][M];

        int maxStones = Integer.MIN_VALUE;

        for(int X=1;X<=Math.min(n-1,2*M);X++){
            int total = prefixSum[n - 1] - (i == 0 ? 0 : prefixSum[i - 1]);
            int opponent = count(piles, i + X, Math.max(M, X), prefixSum, dp);
            int current = total - opponent;
            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M]=maxStones;


    }
}