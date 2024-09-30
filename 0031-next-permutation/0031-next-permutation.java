class Solution {
    public void nextPermutation(int[] nums) {
        int i, j;
        for(i = nums.length-2; i>=0; i-- ){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i<0){
            reverse(nums, 0, nums.length-1);
        }else{
            for(j = nums.length-1; j>=0; j-- ){
                if(nums[i]<nums[j]){
                    break;
                }
            }
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
        }
        
        
    }
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void reverse(int[] a, int i , int j ){
        while(i<j){
            swap(a, i++, j--);
        }
    }
}