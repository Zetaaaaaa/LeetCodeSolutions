class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int []row = new int[grid.length];
        int []column = new int[grid[0].length];
        for(int i = 0; i < grid.length;i++){
            int mr = 0, mc = 0;
            for (int j = 0;j < grid[i].length;j++){
                if(grid[i][j] > mr)
                    mr = grid[i][j];
                if(grid[j][i] > mc)
                    mc = grid[j][i];
            }
            row[i] = mr;
            column[i] = mc;
        }
        int s = 0;
        for(int i=0;i<row.length;i++){
            for(int j=0;j<column.length;j++){
                s += Math.min(row[i], column[j])-grid[i][j];
            }
        }
        return s;
    }
}
