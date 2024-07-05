class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int t = x, d = 0;
        while(t > 0){
            d = d + (t % 10);
            t = t/10;
        }
        return x % d == 0 ? d:-1;
    }
}