class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int d = numBottles;
        while(numBottles >= numExchange){
            int s = numBottles%numExchange;
            int q = numBottles/numExchange;
            d = d + q;
            numBottles = q + s;
        }
        return d;
    }
}