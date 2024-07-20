class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend > 0) != (divisor > 0);
        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);
         if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int q = 0;
        while (divd >= divs) {
            int count = 0;
            while (divs << count <= divd) {
                count++;
            }
            divd -= divs << (count - 1);
            q += 1 << (count - 1);
        }
        return neg ? -q : q;
    }
}
