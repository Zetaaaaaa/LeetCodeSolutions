class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;
        boolean found = false;
        int x = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                x = mid;
                found = true;
                break;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (!found) {
            return new int[]{-1, -1};
        }

        l = x;
        r = x;

        while (l >= 0 && nums[l] == target) {
            l--;
        }
        while (r < nums.length && nums[r] == target) {
            r++;
        }

        return new int[]{l + 1, r - 1};
    }
}