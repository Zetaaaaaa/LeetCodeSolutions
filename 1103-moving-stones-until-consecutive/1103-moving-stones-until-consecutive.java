class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        if (y - x == 1 && z - y == 1) return new int[]{0, 0};
        return new int[] {
            getMin(x, y, z), getMax(x, y, z)
        };
    }

    public int getMin(int x, int y, int z) {
        if (y - x == 1 || z - y == 1) return 1;
        if (y - x == 2 || z - y == 2) return 1;
        return 2;
    }

    public int getMax(int x, int y, int z) {
        return (y-x)-1 + (z-y)-1;
    }
}