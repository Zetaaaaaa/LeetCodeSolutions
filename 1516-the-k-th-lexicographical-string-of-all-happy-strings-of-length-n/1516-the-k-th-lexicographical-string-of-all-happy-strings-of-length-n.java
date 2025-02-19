class Solution {
    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        char[] ch = {'a','b','c'};

        helper(ans, n , "" , ch);
        if(k>ans.size()) return "";

        return ans.get(k-1);
    }

    public void helper(List<String> ans, int n, String str, char[] ch){
        if(str.length()==n){
            ans.add(str);
            return;
        }
        for(char c: ch){
            if(str.isEmpty() || str.charAt(str.length()-1) != c){
                helper(ans, n, str+c, ch);
            }
        }
    }
}