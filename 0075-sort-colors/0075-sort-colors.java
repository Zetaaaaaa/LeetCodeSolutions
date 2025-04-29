class Solution {
    public void sortColors(int[] nums) {
        int [] arr = new int[3];
        for(int num : nums){
            arr[num]++;
        }
        int cc = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < arr[i]; j++){
                nums[cc++] = i;
            }
        }
    }
}