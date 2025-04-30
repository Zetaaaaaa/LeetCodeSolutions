class Solution {
    public int findNumbers(int[] nums) {
        int ctr = 0;
        for(int num : nums){
            int d = (int)Math.log10(num);
            if(d % 2 != 0)  ctr++;
        }
        return ctr;
    }
}