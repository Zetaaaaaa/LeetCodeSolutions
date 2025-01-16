class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        for(int i : nums1){
            xor1 ^= i;
        }
        for(int j : nums2){
            xor2 ^= j;
        }
        int ans = 0;
        if(nums2.length % 2 == 1)   ans ^= xor1;
        if(nums1.length % 2 == 1)   ans ^= xor2;
        return ans;
    }
}