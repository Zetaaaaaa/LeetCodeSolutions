class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long firstRowSum = 0, secondRowSum = 0, minimumSum = Long.MAX_VALUE;

        for (int num : grid[0]) {
            firstRowSum += num;
        }

        for (int turnIndex = 0; turnIndex < n; turnIndex++) {
            firstRowSum -= grid[0][turnIndex];
            long maxPointsForSecondRobot = Math.max(firstRowSum, secondRowSum);
            if (maxPointsForSecondRobot < minimumSum) {
                minimumSum = maxPointsForSecondRobot;
            }
            secondRowSum += grid[1][turnIndex];
        }

        return minimumSum;
    }
}