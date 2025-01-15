class Solution {
    public static int minimizeXor(final int num1, final int num2) {
        int p1 = Integer.bitCount(num1), p2 = Integer.bitCount(num2);
        return Integer.expand(-1 << (p1 > p2 ? p1 - p2 : 0), num1) + Integer.expand((1 << (p2 > p1 ? p2 - p1 : 0)) - 1, ~num1);
    }
}