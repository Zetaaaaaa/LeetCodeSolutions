class Solution {
    public long countOfSubstrings(String word, int k) {
   return solve(word,k)-solve(word,k+1);
    }
    public long solve(String word, int k){
        int[] arr=new int[26];
        int l = 0;
        int h = 0;
        long count = 0;
        int c = 0;
        int v = 0;
        while (h < word.length()) {
            char ch = word.charAt(h);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                arr[ch-'a']++;
                if (arr[ch-'a'] == 1){
                    v++;
                }
            } else{  c++; }
            while(c >= k && v == 5) {
                count+=(word.length()-h);
                char ch2 = word.charAt(l);
                if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                    arr[ch2-'a']--;
                    if (arr[ch2-'a'] == 0) {
                        v--;
                    }
                } else c--;
                l++;
            }   
            h++;
        }
        return count;
    }
}