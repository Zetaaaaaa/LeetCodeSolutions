class Solution {
    public int m,n;
    public int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void bfs(Queue<int[]>q, int heights[][],boolean visited[][]){
        // perform the classic bfs
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int i=curr[0],j=curr[1];
            for(int d[]:directions){
                int x=i+d[0];
                int y=j+d[1];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if(visited[x][y]) continue;
                if(heights[x][y]<heights[i][j]) continue;
                visited[x][y]=true;
                q.offer(new int[]{x,y});
            }
        }
    }
    public void dfs(int i,int j,int heights[][],boolean visited[][]){
        if(visited[i][j]) return;
        visited[i][j]=true;
        for(int d[]:directions){
            int x=i+d[0];int y=j+d[1];
            if(x<0 || x>=n || y<0 || y>=m) continue;
            if(heights[x][y]<heights[i][j]) continue;
            dfs(x,y,heights,visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];
        Queue<int[]> pacificQ=new LinkedList<>();
        Queue<int[]> atlanticQ=new LinkedList<>();

        for(int i=0;i<n;i++) dfs(i,0,heights,pacific);
        for(int j=0;j<m;j++) dfs(0,j,heights,pacific);
        for(int j=0;j<m;j++) dfs(n-1,j,heights, atlantic);
        for(int i=0;i<n;i++) dfs(i,m-1,heights, atlantic);

        // for(int i=0;i<n;i++){
        //     pacific[i][0]=true;
        //     pacificQ.offer(new int[]{i,0});
        // }
        // for(int j=0;j<m;j++){
        //     pacific[0][j]=true;
        //     pacificQ.offer(new int[]{0,j});
        // }
        // for(int i=0;i<n;i++){
        //     atlantic[i][m-1]=true;
        //     atlanticQ.offer(new int[]{i,m-1});
        // }
        // for(int j=0;j<m;j++){
        //     atlantic[n-1][j]=true;
        //     atlanticQ.offer(new int[]{n-1,j});
        // }
        // bfs(pacificQ,heights,pacific);
        // bfs(atlanticQ,heights,atlantic);

        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
}