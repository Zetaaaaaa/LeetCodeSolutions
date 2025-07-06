class FindSumPairs {

    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int i : map1.keySet()) {
            ans += map2.getOrDefault(tot - i, 0) * map1.get(i);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */