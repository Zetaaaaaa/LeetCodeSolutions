class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String rev_s = new StringBuilder(s).reverse().toString();
        String s_new = s + "#" + rev_s;
        int[] kmp = computeKMP(s_new);
        int longestPrefixLength = kmp[s_new.length() - 1];
        return rev_s.substring(0, s.length() - longestPrefixLength) + s;
    }
    private int[] computeKMP(String s) {
        int[] kmp = new int[s.length()];
        int j = 0; 
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = kmp[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            kmp[i] = j;
        }
        
        return kmp;
    }
}