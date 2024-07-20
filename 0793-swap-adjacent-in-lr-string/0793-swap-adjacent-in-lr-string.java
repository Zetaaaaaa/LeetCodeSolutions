class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;

        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }

            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }

            if (i == start.length() && j == end.length()) {
                return true;
            }

            if (i == start.length() || j == end.length()) {
                return false;
            }

            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }

            char c = start.charAt(i);

            if (c == 'R') {
                if (i > j) {
                    return false;
                }
            } else {
                if (i < j) {
                    return false;
                }
            }

            i++;
            j++;
        }

        while (i < start.length() && start.charAt(i) == 'X') {
            i++;
        }

        while (j < end.length() && end.charAt(j) == 'X') {
            j++;
        }

        if (i == start.length() && j == end.length()) {
            return true;
        }
        return false;
    }
}