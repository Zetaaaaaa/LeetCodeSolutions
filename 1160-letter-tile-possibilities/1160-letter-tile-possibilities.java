import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numTilePossibilities(String tiles) {
        return generateSubsets(tiles).size();
    }

    private Set<String> generateSubsets(String s) {
        Set<String> result = new HashSet<>();
        char[] charArray = s.toCharArray();
        boolean[] used = new boolean[charArray.length];
        backtrack(charArray, used, "", result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, String current, Set<String> result) {
        if (!current.isEmpty()) {
            result.add(current);
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            backtrack(chars, used, current + chars[i], result);
            used[i] = false;
        }
    }
}
