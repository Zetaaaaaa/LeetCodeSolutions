class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        for(int i = 0; i < numRows - 1; i++){
            List<Integer> r1 = new ArrayList<>();
            r1.add(0);
            r1.addAll(ans.get(ans.size() - 1));
            r1.add(0);
            List<Integer> r2 = new ArrayList<>();
            for(int j = 0; j < r1.size() - 1; j++){
                r2.add(r1.get(j) + r1.get(j+1));
            }
            ans.add(r2);
        }
        return ans;
    }
}