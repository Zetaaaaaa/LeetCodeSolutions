class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()]= true;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=0;j<wordDict.size();j++){
                if(i + wordDict.get(j).length() <= s.length() && s.substring(i,i+wordDict.get(j).length()).equals(wordDict.get(j))){
                    dp[i] = dp[i+ wordDict.get(j).length()];
                    if (dp[i]) break;
                }
                
            }
        }
        return dp[0];
    }
}