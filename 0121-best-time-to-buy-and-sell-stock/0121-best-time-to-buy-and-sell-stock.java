class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int mp = prices[0];
        int prof = 0;
        for(int i = 1; i <n;i++){
            if(prices[i] < mp){
                mp = prices[i];
            }
            else{
                prof = Math.max(prof, prices[i] - mp);
            }
        }
        return prof;
    }
}