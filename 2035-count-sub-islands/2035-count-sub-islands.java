class Solution {
    private int ROWS;
    private int COLS;
    private int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private Set<String> visited;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        ROWS = grid1.length;
        COLS = grid1[0].length;
        visited = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String key = getKey(r, c);
                if (!visited.contains(key)) {
                    visited.add(key);
                    if (grid2[r][c] == 1 && isSub(grid1, grid2, r, c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private String getKey(int r, int c) {
        return r + "-" + c;
    }

    private boolean isSub(int[][] grid1, int[][] grid2, int r, int c) {
        boolean areSubParts = (grid1[r][c] == 1);
        for (int[] d : dir) {
            int rNext = r + d[0];
            int cNext = c + d[1];
            String keyNext = getKey(rNext, cNext);
            if (0 <= rNext && rNext < ROWS && 0 <= cNext && cNext < COLS && !visited.contains(keyNext)) {
                visited.add(keyNext);
                if (grid2[rNext][cNext] == 1) {
                    boolean isNextSub = isSub(grid1, grid2, rNext, cNext);
                    areSubParts = areSubParts && isNextSub;
                }
            }
        }
        return areSubParts;
    }
}