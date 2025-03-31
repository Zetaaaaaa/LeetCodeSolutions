class Solution {
    public int minimumSum(int n, int k) {
        int [] sums = new int[100];
        int i = 1, res = 0;
        while(n > 0){
            if(i <= k && sums[k-i] == 0){
                res += i;
                sums[i] = 1;
                n--;
            }
            else if(i > k && n > 0){
                res += i;
                n--;
            }
            i++;
        }
        return res;
    }
}