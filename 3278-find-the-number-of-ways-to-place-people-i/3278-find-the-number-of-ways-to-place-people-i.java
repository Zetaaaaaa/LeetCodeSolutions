class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 <= x2 && y1 >= y2 && (x1 < x2 || y1 > y2)) {
                    boolean valid = true;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) continue;
                        int x3 = points[k][0], y3 = points[k][1];

                        if (x1 <= x3 && x3 <= x2 && y1 >= y3 && y3 >= y2) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) ans++;
                }
            }
        }
        return ans;
    }
}