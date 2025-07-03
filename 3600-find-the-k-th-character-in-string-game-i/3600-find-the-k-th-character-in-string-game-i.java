class Solution {
    public char kthCharacter(int k) {
        String s = "a";
        while(s.length() <= k){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                char ch1 = (char) ((ch - 'a' + 1) % 26 + 'a');
                res.append(ch1);
            }
            s += res.toString();
        }
        return s.charAt(k-1);
    }
}