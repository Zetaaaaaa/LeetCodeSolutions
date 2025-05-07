class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length - 1, n = moveTime[0].length - 1;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        heap.add(new int[]{0, 0, 0});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> visited = new HashSet<>();

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int time = current[0], r = current[1], c = current[2];
            if (r == m && c == n) return time;
            for (int[] dir : directions) {
                int row = r + dir[0], col = c + dir[1];
                if (row >= 0 && row <= m && col >= 0 && col <= n && !visited.contains(row + "," + col)) {
                    heap.add(new int[]{Math.max(time, moveTime[row][col]) + 1, row, col});
                    visited.add(row + "," + col);
                }
            }
        }
        return -1; 
    }
}