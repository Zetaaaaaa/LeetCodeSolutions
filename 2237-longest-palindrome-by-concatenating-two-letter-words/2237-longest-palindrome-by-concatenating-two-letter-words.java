import java.util.HashMap;

class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        int palindromeLength = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : freqMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed)) {
                int count = freqMap.get(word);
                if (count % 2 == 0) {
                    palindromeLength += count * 2;
                } else {
                    palindromeLength += (count - 1) * 2;
                    hasMiddle = true;
                }
            } else if (freqMap.containsKey(reversed)) {
                int pairs = Math.min(freqMap.get(word), freqMap.get(reversed));
                palindromeLength += pairs * 4;
                freqMap.put(word, 0);
                freqMap.put(reversed, 0);
            }
        }

        if (hasMiddle) {
            palindromeLength += 2;
        }

        return palindromeLength;
    }
}
