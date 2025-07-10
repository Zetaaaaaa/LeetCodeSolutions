class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long ctr = 9;
        long start = 1;
        while(n > len * ctr){
            n -= len * ctr;
            len++;
            ctr *= 10;
            start *= 10;
            
        }
        long number = start + (n - 1) / len;
        int idx = len - (n - 1) % len;
        for (int i = 1; i < idx; i++) {
            number /= 10;
        }
        return (int)number % 10;
    }
}