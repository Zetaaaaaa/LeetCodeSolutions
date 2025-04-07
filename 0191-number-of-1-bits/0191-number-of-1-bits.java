class Solution {
    public int hammingWeight(int n) {
        String bin = Integer.toBinaryString(n);
        char[] arr = bin.toCharArray();
        int ctr = 0;
        for(char ch : arr){
            if(ch == '1'){
                ctr++;
            }
        }
        return ctr;
    }
}