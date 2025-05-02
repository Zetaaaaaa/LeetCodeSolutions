class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int midValue;
        while (start <= end) {
            mid = start + (end-start)/2;
            midValue = nums[mid];
            if (midValue < target) {
                start = mid + 1;
            } else if (midValue > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}