class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int l = values.length;
        int sc = Integer.MIN_VALUE;
        int value = values[0];
        for(int i = 1; i < l; i++){
            sc = Math.max(sc, value + values[i] - i);
            value = Math.max(value, values[i] + i);
        }
        return sc;
    }
}