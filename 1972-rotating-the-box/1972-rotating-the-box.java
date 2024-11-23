class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length, cols = box[0].length;
        char[][] result = new char[cols][rows];
        for (char[] row : result) {
            java.util.Arrays.fill(row, '.');
        }
        for (int i = 0; i < rows; i++) {
            int emptyPosition = cols - 1;
            for (int j = cols - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    result[j][rows - i - 1] = '*';
                    emptyPosition = j - 1;
                } else if (box[i][j] == '#') {
                    result[emptyPosition][rows - i - 1] = '#';
                    emptyPosition--;
                }
            }
        }
        
        return result;
    }
}