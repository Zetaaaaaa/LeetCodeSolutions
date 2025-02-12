class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        finder(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    void finder(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int st){
        if(target < 0)  return;

        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = st; i < nums.length;i++){
            temp.add(nums[i]);
            finder(res, temp, nums, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}