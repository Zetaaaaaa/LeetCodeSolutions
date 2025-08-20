class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    ans++;
                    ans = ans + bfs(matrix,i,j);
                }
            }
        }
        return ans;
    }

    public int bfs(int[][] matrix,int row,int col){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0,1},{1,0},{1,1}};
        queue.add(new int[]{row,col});
        isVisited[row][col] = true;
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                for(int[] direction : directions){
                    int r = curr[0] + direction[0];
                    int c = curr[1] + direction[1];
                    if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] == 0){
                        return ans;
                    }
                    if(!isVisited[r][c]){
                        queue.add(new int[]{r,c});
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}