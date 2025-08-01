class Solution {
    public int superPow(int a, int[] b) {
        if (a == 1) {
            return 1;
        }

        int ans = 1;
        int len = b.length;
        for (int i = len - 1; i >= 0; i--) {
            ans = (int) ((long) ans * binaryPower(a, b[i]) % 1337);
            a = binaryPower(a, 10);
        }

        return ans;
    }

    public static int binaryPower(int base, int exp) {
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (int) ((long) res * base % 1337);
            }

            base = (int) ((long) base * base % 1337);
            exp = exp >> 1;
        }

        return res;
    }
}