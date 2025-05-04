class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] ctr = new int[100];
        int ans = 0;
        for(int[] d : dominoes){
            int a = d[0], b = d[1];
            int k = a < b ? a * 10 + b : b * 10 + a;
            ans += ctr[k];
            ctr[k]++;
        }
        return ans;
    }
}