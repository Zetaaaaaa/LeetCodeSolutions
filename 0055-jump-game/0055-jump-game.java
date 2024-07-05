class Solution {
    public boolean canJump(int[] nums) {
       int tar = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > tar) return false;
           if(tar > nums.length - 1) return true;
           tar = Math.max(tar, i + nums[i]);
       } 
       return true;
    }
}