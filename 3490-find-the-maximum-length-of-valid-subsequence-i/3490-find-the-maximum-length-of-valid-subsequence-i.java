class Solution {
    public int maximumLength(int[] nums) {
        int e = 0, o = 0;
        int l1 = 0, l2 = 0;
        for(int num : nums){
            num %= 2;
            if(num == 0){
                e++;
                l1 = Math.max(l1, l2 + 1);
            }
            else{
                o++;
                l2 = Math.max(l2, l1 + 1);
            }
        }
        return Math.max(Math.max(o,e), Math.max(l1,l2));
    }
}