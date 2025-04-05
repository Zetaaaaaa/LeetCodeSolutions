
class Solution {
    private int total = 0;

    public int subsetXORSum(int[] nums) {
        find(0, new ArrayList<>(), nums);
        return total;
    }

    private void find(int index, List<Integer> cur, int[] nums) {
        int xorSum = 0;
        for (int num : cur) {
            xorSum ^= num;
        }
        total += xorSum;

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            find(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
