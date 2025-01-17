class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int i : derived) {
            xorSum ^= i;
        }
        return xorSum == 0;
    }
}