class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1){
                    row[i]++;col[j]++;
                }
            }
        }
        long ans = 0;
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(grid[i][j] == 1 && row[i] >= 2 && col[j] > 1){
                    int rowc = row[i];int colc = col[j];
                    ans += (rowc-1) *( colc-1);
                }
            }
        }
        return ans;
    }
}