class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int summ = 0;
        for(int i =0;i<m;i++){
            summ += rolls[i];
        }
        int sumn = ((m + n)* mean) - summ;
        if(sumn > 6 * n || sumn < n) 
            return new int[] {};
        int[] ans = new int[n];
        Arrays.fill(ans, sumn / n);
        sumn %= n;
        for (int i = 0; i < sumn; i++)
        ++ans[i];

    return ans;

    }
}