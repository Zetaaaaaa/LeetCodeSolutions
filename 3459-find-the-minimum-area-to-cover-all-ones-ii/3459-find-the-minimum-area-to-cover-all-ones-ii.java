class Solution {
    public int minimumSum(int[][] grid) {
        int[][] rgrid = rotate(grid);
        return Math.min(solve(grid),solve(rgrid));
    }
    private int[][] rotate(int[][] arr){
        int m = arr.length, n = arr[0].length;
        int[][] ret = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ret[n-j-1][i] = arr[i][j];
            }
        }
        return ret;
    }
    private int solve(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int res = m * n;
        for(int i=0;i+1<m;i++){
            for(int j=0;j+1<n;j++){
                res = Math.min(res,minimumSum2(grid,0,i,0,n-1)+minimumSum2(grid,i+1,m-1,0,j)+minimumSum2(grid,i+1,m-1,j+1,n-1));
                res = Math.min(res,minimumSum2(grid,0,i,0,j)+minimumSum2(grid,0,i,j+1,n-1)+minimumSum2(grid,i+1,m-1,0,n-1));
            }
        }
        for(int i=0;i+2<m;i++){
            for(int j=i+1;j+1<m;j++){
                res = Math.min(res,minimumSum2(grid,0,i,0,n-1)+minimumSum2(grid,i+1,j,0,n-1)+minimumSum2(grid,j+1,m-1,0,n-1));
            }
        }
        return res;
    }
    private int minimumSum2(int[][] grid,int u,int d,int l,int r){
        int mini = grid.length,maxi = 0,minj = grid[0].length,maxj = 0;
        for(int i=u;i<=d;i++){
            for(int j=l;j<=r;j++){
                if(grid[i][j]==1){
                    mini = Math.min(mini,i);
                    minj = Math.min(minj,j);
                    maxi = Math.max(maxi,i);
                    maxj = Math.max(maxj,j);
                }
            }
        }
        return mini <= maxi ? (maxi - mini + 1) * (maxj - minj + 1) : Integer.MAX_VALUE/3;
    }
}