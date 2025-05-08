class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] rmt = moveTime;
        int r = rmt.length;
        int c = rmt[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, 1});

        int[][] mat = new int[r][c];
        for (int[] row : mat) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        mat[0][0] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2], sc = cur[3];

            if (x == r - 1 && y == c - 1) {
                return t;
            }

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    int wt = Math.max(rmt[nx][ny] - t, 0);
                    int nt = t + sc + wt;

                    if (nt < mat[nx][ny]) {
                        mat[nx][ny] = nt;
                        int nsc = (sc == 2) ? 1 : 2;
                        pq.offer(new int[]{nt, nx, ny, nsc});
                    }
                }
            }
        }

        return -1;
    }
}
