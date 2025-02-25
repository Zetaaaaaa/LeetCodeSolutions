class Solution {
    public int numOfSubarrays(int[] arr) {
        long odds = 0, prefixSum = 0;
        for(int i : arr){
            prefixSum += i;
            odds += prefixSum % 2;
        }
        odds += (arr.length - odds) * odds;
        return (int)(odds % 1000000007);
    }
}