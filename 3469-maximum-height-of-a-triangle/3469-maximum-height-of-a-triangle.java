class Solution {
    private int buildTriangle(int a, int b, int row) {
        if (a < row) return 0;
        return buildTriangle(b, a - row, row + 1) + 1;
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(buildTriangle(red, blue, 1), buildTriangle(blue, red, 1));
    }
}