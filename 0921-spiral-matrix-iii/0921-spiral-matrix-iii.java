class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int count=0,i=rStart,j=cStart;
        int[][] res=new int[cols*rows][2];
        int r=0,c=0;
        int steps=1;
        if(i<rows && i>=0 && j<cols && j>=0){
            res[r][c]=i;
            c++;
            res[r][c]=j;
            r++;
            count++;
            c=0;
        }
        while(count<(rows*cols)){
            for(int k=0;k<steps;k++){
                j++;
                if(i<rows && i>=0 && j<cols && j>=0){
                    res[r][c]=i;
                    c++;
                    res[r][c]=j;
                    r++;
                    c=0;
                    count++;
                }
            }
            for(int k=0;k<steps;k++){
                i++;
                if(i<rows && i>=0 && j<cols && j>=0){
                    res[r][c]=i;
                    c++;
                    res[r][c]=j;
                    r++;
                    c=0;
                    count++;
                }
            }
            steps++;
            for(int k=0;k<steps;k++){
                j--;
                if(i<rows && i>=0 && j<cols && j>=0){
                    res[r][c]=i;
                    c++;
                    res[r][c]=j;
                    r++;
                    c=0;
                    count++;
                }
            }            
            for(int k=0;k<steps;k++){
                i--;
                if(i<rows && i>=0 && j<cols && j>=0){
                    res[r][c]=i;
                    c++;
                    res[r][c]=j;
                    r++;
                    c=0;
                    count++;
                }
            }
            steps++;
        }
        return res;
    }
}