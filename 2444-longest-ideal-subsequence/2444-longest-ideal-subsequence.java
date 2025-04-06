public class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int maxLength = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            int maxLen = 0; 
            for (int i = Math.max(0, index - k); i <= Math.min(25, index + k); i++) {
                maxLen = Math.max(maxLen, dp[i]);
            }
            dp[index] = maxLen + 1;
            maxLength = Math.max(maxLength, dp[index]);
        }

        return maxLength;
    }
}