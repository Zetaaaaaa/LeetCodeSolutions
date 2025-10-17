class Solution {
    private Map<Long, Integer> memo = new HashMap<>();

    private int dfs(int index, String s, int charMask, boolean canChange, int k) {
        if (index == s.length())
            return 0;
        long key = ((long) index << 27) | ((long) charMask << 1) | (canChange ? 1L : 0L);
        if (memo.containsKey(key))
            return memo.get(key);
        int currentBit = 1 << (s.charAt(index) - 'a');
        int updatedMask = charMask | currentBit;
        int maxPartitions;
        if (Integer.bitCount(updatedMask) > k)
            maxPartitions = 1 + dfs(index + 1, s, currentBit, canChange, k);
        else
            maxPartitions = dfs(index + 1, s, updatedMask, canChange, k);
        if (canChange) {
            for (int c = 0; c < 26; c++) {
                int newBit = 1 << c;
                int newMask = charMask | newBit;
                int partitions;
                if (Integer.bitCount(newMask) > k)
                    partitions = 1 + dfs(index + 1, s, newBit, false, k);
                else
                    partitions = dfs(index + 1, s, newMask, false, k);
                maxPartitions = Math.max(maxPartitions, partitions);
            }
        }
        memo.put(key, maxPartitions);
        return maxPartitions;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        return 1 + dfs(0, s, 0, true, k);
    }
}