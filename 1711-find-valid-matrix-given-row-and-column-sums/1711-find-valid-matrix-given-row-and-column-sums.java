class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int ans[][] = new int[m][n];
        int a = 0, b = 0;
        while(a<m && b < n){
            int m1 = Math.min(rowSum[a], colSum[b]);
            ans[a][b] = m1;
            rowSum[a] -= m1;
            colSum[b] -= m1;
            if(rowSum[a] == 0 ) a++;
            if(colSum[b] == 0)  b++;
        }
        return ans;
    }
}