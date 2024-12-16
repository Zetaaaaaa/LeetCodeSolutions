class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int s=queue.poll();
            int m=s*multiplier;
            queue.add(m);
           for(int j=0;j<nums.length;j++){
            if(nums[j]==s){
                nums[j]=m;
                break;
            }
           }

        }
        return nums;
    }
}