class Solution {
    public int findNumbers(int[] nums) {
        int ctr = 0;
        for(int num : nums){
            if(((int)Math.log10(num)) % 2 != 0) ctr++;
        }
        return ctr;
    }
}