class Solution {
    public int possibleStringCount(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length() - 1; i++) {
            if(word.charAt(i) == word.charAt(i + 1)) {
                if(!map.containsKey(word.charAt(i))) {
                    map.put(word.charAt(i), 1);
                } else {
                    map.put(word.charAt(i),  map.get(word.charAt(i)) + 1);
                }
            }
        }
        int ctr = 0;
        for(char i : map.keySet()) {
            ctr += map.get(i);
        }
        return ++ctr;
    }
}