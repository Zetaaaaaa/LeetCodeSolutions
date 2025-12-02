class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int[] p: points){
            int y = p[1];
            if(!mp.containsKey(y)){
                mp.put(y, 0);
            }
            mp.put(y, mp.get(y) + 1);
        }

        int ans = 0;
        long prefix = 0L;
        for(int cnt: mp.values()){
            long currSegment = (long) (cnt) * (cnt - 1) / 2;
            currSegment %= mod;
            ans = (ans % mod + (int) ((currSegment * prefix) % mod)) % mod;
            prefix = (prefix % mod + currSegment) % mod;
        }

        return ans;
    }
}