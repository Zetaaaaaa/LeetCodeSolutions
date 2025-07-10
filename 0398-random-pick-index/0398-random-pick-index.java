import java.util.Random;

class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int picked = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    picked = i;
                }
            }
        }

        return picked;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */