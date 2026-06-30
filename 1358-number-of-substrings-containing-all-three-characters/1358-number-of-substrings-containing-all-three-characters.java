class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] hash = new int[3];
        int i = 0, j = 0;
        for(j = 0; j < n; j++){
            char ch = s.charAt(j);
            hash[ch - 'a']++;
            while(isValid(hash)){
                ans += (n - j);
                ch = s.charAt(i);
                hash[ch - 'a']--;
                i++;
            }
        }
        return ans;
    }
    private boolean isValid(int[] hash){
        return hash[0] > 0 && hash[1] > 0 && hash[2] > 0;
    }
}