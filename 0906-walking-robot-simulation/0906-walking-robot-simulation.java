public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] directionVectors = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int[][] dirChangeMap = {
            {3, 1},
            {0, 2},
            {1, 3},
            {2, 0}
        };

        int currDirection = 0;
        int x = 0, y = 0;
        int maxDist = 0;

        for (int command : commands) {
            if (command > 0) {
                int dx = directionVectors[currDirection][0];
                int dy = directionVectors[currDirection][1];
                for (int i = 0; i < command; i++) {
                    int nextX = x + dx;
                    int nextY = y + dy;
                    if (obs.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                }
                maxDist = Math.max(maxDist, x * x + y * y);
            } else {
                currDirection = dirChangeMap[currDirection][command == -1 ? 1 : 0];
            }
        }

        return maxDist;
    }
}