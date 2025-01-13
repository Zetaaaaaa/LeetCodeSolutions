class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> M = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            M.put(c, M.getOrDefault(c, 0) + 1);
        }

        int de = 0;

        for (int count : M.values()) {
            if (count > 2) {
                if (count % 2 == 0) {
                    de += (count - 2);
                } else {
                    de += (count - 1);
                }
            }
        }

        return s.length() - de;
    }
}