class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int mi = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) { 
                    min = matrix[i][j];
                    mi = j;
                }
            }
            int max = min;
            for (int k = 0; k < matrix.length; k++) { 
                if (matrix[k][mi] > max) max= matrix[k][mi];
            }
            if (max == min) list.add(max);
        }
        return list;
    }
}