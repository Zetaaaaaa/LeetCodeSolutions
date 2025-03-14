class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];

        int sumAlice = 0;
        for (int a : aliceSizes)
            sumAlice += a;

        int sumBob = 0;
        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) {
            sumBob += b;
            bobSet.add(b);
        }

        int targetDiff = (sumBob - sumAlice) / 2;
        for (int aliceSize : aliceSizes) {
            int bobSize = aliceSize + targetDiff;
            if (bobSet.contains(bobSize)) {
                ans[0] = aliceSize;
                ans[1] = bobSize;
                return ans;
            }
        }

        return ans;
    }
}