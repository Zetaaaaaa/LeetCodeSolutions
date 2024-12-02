class Solution {
    int ans = 1;
    public int maxProduct(String s) {
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int array[] : dp){
            Arrays.fill(array, -1);
        }
        return palindromenumber(s,"","", 0, dp);
    }

    public int palindromenumber(String s, String s1, String s2, int idx, int dp[][]){
        int l1 = s1.length(), l2 = s2.length();
        if(isPalindrome(s1) && isPalindrome(s2))
            ans = Math.max(ans, l1 * l2);
        
        dp[l1][l2] = ans;
        if(idx >= s.length())   return dp[l1][l2];

        int c1 = palindromenumber(s, s1 + s.charAt(idx), s2, idx+1, dp);
        int c2 = palindromenumber(s, s1, s2+s.charAt(idx), idx+1, dp);
        int c3 = palindromenumber(s, s1, s2, idx+1, dp);

        return dp[l1][l2];
    }
    public boolean isPalindrome(String str){
        for(int i = 0, j = str.length()-1; i <= j; i++, j--){
            if(str.charAt(i) != str.charAt(j))  return false;
        }
        return true;
    }
}