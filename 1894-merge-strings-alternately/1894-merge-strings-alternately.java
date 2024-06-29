class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans="";

        char arr1[]=word1.toCharArray();
        char arr2[]=word2.toCharArray();

        int a1=0,a2=0;

        while(a1<word1.length()&&a2<word2.length()){
            ans+=arr1[a1++];
            ans+=arr2[a2++];
        }
        while(a1<word1.length()){
            ans+=arr1[a1++];
        }
        while(a2<word2.length()){
            ans+=arr2[a2++];
        }
        return ans;
    }
}