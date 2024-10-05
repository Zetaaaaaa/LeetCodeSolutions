class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 0;
        for(int i = 0; i <(1 << n); i++){
            num = num ^ i & (-i);
            res.add(num);
        }
        return res;
    }
}