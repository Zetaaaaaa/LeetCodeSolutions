class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        memo.put(1, 1);
        memo.put(2, 2);
        return climb(n);
    }
    private int climb(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        else{
            int res = climb(n-1) + climb(n-2);
            memo.put(n,res);
            return res;
        }
    }
}
