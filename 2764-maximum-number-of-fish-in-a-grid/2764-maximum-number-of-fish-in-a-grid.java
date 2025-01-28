class Solution {

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, fishCollected(grid, i, j, m, n));
                }
            }
        }
        return maxFish;
    }

    
    int fishCollected(int[][] grid, int x, int y, int m, int n) {
        int[] xDir = {0, 0, 1, -1};
        int[] yDir = {1, -1, 0, 0};
        int fishCount = grid[x][y];
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + xDir[i];
            int newY = y + yDir[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 0) {
                fishCount += fishCollected(grid, newX, newY, m, n);
            }
        }
        return fishCount;
    }

    
}