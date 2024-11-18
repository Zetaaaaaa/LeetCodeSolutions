class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = code[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + code[i];
        }

        int[] res = new int[n];
        if (k == 0) return res;

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int start = i + 1;
                int end = i + k;
                res[i] = prefixSum[end % n] - (start > 0 ? prefixSum[(start - 1) % n] : 0);
                if (i + k >= n) {
                    res[i] += prefixSum[n - 1];
                }
            }
        } else {
            k = -k;
            for (int i = 0; i < n; i++) {
                int start = (i - k + n) % n;
                int end = (i - 1 + n) % n;
                res[i] = prefixSum[end] - (start > 0 ? prefixSum[(start - 1) % n] : 0);
                if (i - k < 0) {
                    res[i] += prefixSum[n - 1];
                }
            }
            res[0]-=prefixSum[n-1];
        }

        return res;
    }
}