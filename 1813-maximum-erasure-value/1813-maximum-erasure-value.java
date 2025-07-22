class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[100001];
        int left = 0;
        int currsum = 0;
        int maxsum = 0;
        for(int right = 0; right < n; right++){
            while(visited[nums[right]]){
                currsum -= nums[left];
                visited[nums[left]] = false;
                left++;
            }
            currsum += nums[right];
            visited[nums[right]] = true;
            if(currsum > maxsum)    maxsum = currsum;
        }
        return maxsum;
    }
}