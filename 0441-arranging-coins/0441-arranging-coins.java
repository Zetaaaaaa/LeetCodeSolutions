class Solution {
    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        while(end >= start){
            long mid = (end + start) / 2;
            long sum = mid * (mid + 1) / 2;
            if(sum == n){
                return (int)mid;
            }
            else if(sum > n){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return (int)end;
    }
}