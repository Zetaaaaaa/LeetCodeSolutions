class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> single = new ArrayList<>();
            single.add(nums[0]);
            res.add(single);
            return res;
        }
        for (int i = 0; i< nums.length;i++){
            int n = nums[i];
            int[] rem = new int[nums.length - 1];
            int idx = 0;
            for(int j = 0;j<nums.length;j++){
                if(j != i){
                    rem[idx] = nums[j];
                    idx++;
                }
            }
            List<List<Integer>> perm = permute(rem);
            for(List<Integer> p : perm){
                p.add(n);
            }
            res.addAll(perm);
        }
        return res;
    }
}