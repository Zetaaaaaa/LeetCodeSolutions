class Solution {
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, 1, 0, -1};
    private int n;
    
    public int largestIsland(int[][] grid) {
        n = grid.length;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;
        int maxSize = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(grid, r, c, islandId);
                    islandSizes.put(islandId, size);
                    maxSize = Math.max(maxSize, size);
                    islandId++;
                }
            }
        }
        
        if (maxSize == n * n) return maxSize;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    
                    for (int i = 0; i < 4; i++) {
                        int newR = r + dr[i];
                        int newC = c + dc[i];
                        
                        if (isValid(newR, newC) && grid[newR][newC] > 1) {
                            neighborIslands.add(grid[newR][newC]);
                        }
                    }
                    
                    int totalSize = 1;
                    for (int id : neighborIslands) {
                        totalSize += islandSizes.get(id);
                    }
                    maxSize = Math.max(maxSize, totalSize);
                }
            }
        }
        
        return maxSize;
    }
    
    private int dfs(int[][] grid, int r, int c, int islandId) {
        if (!isValid(r, c) || grid[r][c] != 1) {
            return 0;
        }
        
        grid[r][c] = islandId;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            size += dfs(grid, r + dr[i], c + dc[i], islandId);
        }
        
        return size;
    }
    
    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}