class Solution {
    public long flowerGame(int n, int m) {
        long odd = 0, even = 0;
        odd = (n+1)/2;
        even = m/2;
        long odd1 = (m+1)/2;
        long even1 = n/2;

        return odd1*even1 + odd * even;
    }
}