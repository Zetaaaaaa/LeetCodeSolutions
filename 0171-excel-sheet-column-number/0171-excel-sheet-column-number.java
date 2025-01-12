class Solution {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            columnNumber = columnNumber * 26 + (c - 'A' + 1);
        }
        return columnNumber;
    }
}