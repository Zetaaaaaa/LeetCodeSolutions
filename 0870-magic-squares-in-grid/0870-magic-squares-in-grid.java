class Solution {
    public int numMagicSquaresInside(int[][] grid) {
         int count=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(sum(grid,i,j)) count++;
            }
        }
        return count;
    }
    public boolean sum(int grid[][],int row,int col){
        HashSet<Integer> visited=new HashSet<>();
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(visited.contains(grid[i][j]) || grid[i][j]>9 || grid[i][j]==0) return false;
                visited.add(grid[i][j]);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        int sum1=0;
        int sum2=0;
        for(int i=row;i<row+3;i++){
            sum1+=grid[i][col];
            sum2+=grid[i][col+2];
        }
        list.add(sum1);
        list.add(sum2);
        sum1=0;
        sum2=0;
        for(int i=col;i<col+3;i++){
            sum1+=grid[row][i];
            sum2+=grid[row+2][i];
        }
        list.add(sum1);
        list.add(sum2);
        sum1=0;
        sum2=0;
        for(int i=0;i<3;i++){
            sum1+=grid[row+i][col+i];
            sum2+=grid[row+i][col+2-i];
        }
        list.add(sum1);
        list.add(sum2);
        for(int i=0;i<6;i++){
            if(list.get(0)!=list.get(i)) return false;
        }
        return true;
    }
}