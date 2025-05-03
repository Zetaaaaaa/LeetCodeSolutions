class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int x : tops) m.put(x, m.getOrDefault(x, 0) + 1);
        for (int x : bottoms) m2.put(x, m2.getOrDefault(x, 0) + 1);

        int ele = 0, freq = 0, ele2 = 0, freq2 = 0;
        for (int key : m.keySet()) {
            if (m.get(key) >= freq) {
                freq = m.get(key);
                ele = key;
            }
        }
        for (int key : m2.keySet()) {
            if (m2.get(key) >= freq2) {
                freq2 = m2.get(key);
                ele2 = key;
            }
        }
        ele = (m.getOrDefault(ele2, 0) + m2.getOrDefault(ele2, 0)) > (m.getOrDefault(ele, 0) + m2.getOrDefault(ele, 0)) ? ele2 : ele;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != ele && bottoms[i] != ele) return -1;
        }
        return Math.min(tops.length - m.getOrDefault(ele, 0), tops.length - m2.getOrDefault(ele, 0));
    }
}