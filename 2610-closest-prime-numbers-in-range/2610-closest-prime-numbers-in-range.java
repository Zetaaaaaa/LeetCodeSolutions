class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieve = new boolean[right + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int[] res = {-1, -1};
        int temp = -1;
        int mini = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (sieve[i]) {
                if (temp != -1 && i - temp < mini) {
                    res[0] = temp;
                    res[1] = i;
                    mini = i - temp;
                }
                temp = i;
            }
        }

        return res;
    }
}