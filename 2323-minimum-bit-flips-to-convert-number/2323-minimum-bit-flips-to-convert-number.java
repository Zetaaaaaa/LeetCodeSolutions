class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        int bit=start^goal;
        while(bit!=0){
            bit&=(bit-1);
            count++;
        }return count;
    }
}