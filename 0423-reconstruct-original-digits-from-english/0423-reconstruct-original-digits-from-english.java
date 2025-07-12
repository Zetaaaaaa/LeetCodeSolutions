class Solution {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Integer digit = null;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word, int digit) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.digit = digit;
        }
    }

    public String originalDigits(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int[] digits = new int[10];
        String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        Map<Character, Integer> uniqueMap = Map.of(
            'z', 0, 
            'w', 2, 
            'u', 4, 
            'x', 6, 
            'g', 8  
        );

        for (Map.Entry<Character, Integer> entry : uniqueMap.entrySet()) {
            char uniqueChar = entry.getKey();
            int digit = entry.getValue();
            int freq = count.getOrDefault(uniqueChar, 0);
            if (freq > 0) {
                digits[digit] = freq;
                for (char c : words[digit].toCharArray()) {
                    count.put(c, count.get(c) - freq);
                }
            }
        }

        Trie trie = new Trie();
        for (int i = 0; i <= 9; i++) {
            trie.insert(words[i], i);
        }

        backtrack(count, trie.root, trie, digits);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (digits[i]-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    private boolean backtrack(Map<Character, Integer> count, TrieNode node, Trie trie, int[] digits) {
        if (count.values().stream().allMatch(v -> v == 0)) {
            return true;
        }

        for (int digit = 0; digit <= 9; digit++) {
            String word = getWord(digit);
            if (canForm(word, count)) {
                Map<Character, Integer> backup = new HashMap<>(count);
                for (char c : word.toCharArray()) {
                    count.put(c, count.get(c) - 1);
                }
                digits[digit]++;
                if (backtrack(count, trie.root, trie, digits)) {
                    return true;
                }
                digits[digit]--;
                count.clear();
                count.putAll(backup);
            }
        }

        return false;
    }

    private boolean canForm(String word, Map<Character, Integer> count) {
        Map<Character, Integer> temp = new HashMap<>();
        for (char c : word.toCharArray()) {
            temp.put(c, temp.getOrDefault(c, 0) + 1);
            if (temp.get(c) > count.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    private String getWord(int digit) {
        switch (digit) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
        }
        return "";
    }
}
