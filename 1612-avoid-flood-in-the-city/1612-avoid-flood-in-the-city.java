class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();  // lake -> last filled day
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<>();  // available dry days

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                st.add(i); // store dry day index
            } else {
                ans[i] = -1; // raining day
                if (map.containsKey(rains[i])) {
                    // find earliest dry day after last rain
                    Integer it = st.ceiling(map.get(rains[i]));
                    if (it == null) return new int[0]; // impossible
                    ans[it] = rains[i]; // dry this lake
                    st.remove(it);
                }
                map.put(rains[i], i);
            }
        }
        return ans;
    }
}