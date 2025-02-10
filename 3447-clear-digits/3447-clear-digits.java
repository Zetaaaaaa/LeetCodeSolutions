class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        boolean[] marks = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                marks[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (!marks[j]) {
                        marks[j] = true;
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!marks[i]) result.append(s.charAt(i));
        }

        return result.toString();
    }
}