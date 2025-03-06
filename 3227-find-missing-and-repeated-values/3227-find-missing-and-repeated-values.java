class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNums = n * n;

        HashSet<Integer> seen = new HashSet<>();
        int duplicate = -1, missing = -1;
        for (int[] row : grid) {
            for (int num : row) {
                if (!seen.add(num)) {
                    duplicate = num;
                }
            }
        }
        for (int i = 1; i <= totalNums; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
