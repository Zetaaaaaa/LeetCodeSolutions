class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int ctr = 0;
        for(int i = 0; i < l1 && ctr < l2; i++){
            int a = str1.charAt(i);
            int b = str2.charAt(ctr);
            if(a==b || a+1 == b || a-25 == b){
                ctr++;
            }
        }
        if(ctr==l2)  return true;
        return false;
    }
}