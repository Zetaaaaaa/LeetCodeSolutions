class Solution {
    private boolean isVowelIndex(int index) {
        String vowel = "aeiou";
        return (index == (vowel.charAt(0) - 'a')) ||
               (index == (vowel.charAt(1) - 'a')) ||
               (index == (vowel.charAt(2) - 'a')) ||
               (index == (vowel.charAt(3) - 'a')) ||
               (index == (vowel.charAt(4) - 'a'));
    }

    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int vFreq = 0, cFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (isVowelIndex(i)) {
                vFreq = Math.max(vFreq, freq[i]);
            } else {
                cFreq = Math.max(cFreq, freq[i]);
            }
        }
        return vFreq + cFreq;
    }
}