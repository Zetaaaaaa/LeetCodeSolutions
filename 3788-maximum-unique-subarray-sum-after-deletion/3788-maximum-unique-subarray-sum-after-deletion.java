class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = -101;{
            for(int i=0;i<nums.length;i++){
                if(nums[i]<0 || (set.contains(nums[i]))){
                    if(sum<0){
                        sum = Math.max(sum,nums[i]);
                    }
                    continue;
                }
                else{
                    sum = Math.max(sum,0);
                    sum = sum + nums[i];
                    set.add(nums[i]);
                }
            }
        }
        return sum;
    }
}