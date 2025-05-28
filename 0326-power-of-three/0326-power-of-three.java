class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double log3 = Math.log(n) / Math.log(3);
        return Math.abs(log3 - Math.round(log3)) < 1e-10;
    }
}