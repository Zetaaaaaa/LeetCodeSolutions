class Solution {
    public int countDigitOne(int n) {
        if(n <= 0)  return 0;
        int temp = n, x = 1 ,res = 0;
        while(temp>0){
            int d = temp % 10;
            temp /= 10;
            res += temp * x;
            if(d==1)    res += n % x + 1;
            if(d > 1)   res += x;
            x *= 10;
        }
        return res;
    }
}