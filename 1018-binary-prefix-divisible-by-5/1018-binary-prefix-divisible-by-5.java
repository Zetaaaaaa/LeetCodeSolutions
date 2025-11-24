class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int track = 0;
        for(int num : nums){
            track = ((track * 2) + num) % 5;
            res.add(track == 0);
        }
        return res;
    }
}