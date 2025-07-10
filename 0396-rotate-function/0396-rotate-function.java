class Solution {
    
    public int maxRotateFunction(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       int diff=0;
       

       for(int i=0;i<n;i++){
          totalSum += nums[i];
          diff += i*nums[i];
       }
      
      int max =diff;

      for(int i = n-1;i>0;i--){
        max = Math.max(max,diff+totalSum-(n*nums[i]));
        diff=diff+totalSum-(n*nums[i]);
      }

      return max;

    }
 

}