class Solution {
    public int minOperations(int[] nums, int k) {
        boolean equ = true;
        for(int num : nums){
            if(num != k){
                equ = false;
                break;
            }
        }
        if(equ) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > k){
                set.add(num);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        if(!set.isEmpty() && min >= k){
            return set.size();
        }
        return -1;
    }

}