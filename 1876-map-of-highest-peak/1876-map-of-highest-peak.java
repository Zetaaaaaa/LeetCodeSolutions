class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int heights[][] = new int[isWater.length][isWater[0].length];
        for(int i = 0; i < isWater.length; i++){
            for(int j = 0; j < isWater[0].length;j++){
                heights[i][j] = isWater.length + isWater[0].length;
            }
        }
        for(int i = 0; i < isWater.length; i++){
            for(int j = 0; j < isWater[0].length;j++){
                if(isWater[i][j] == 1)  heights[i][j] = 0;
                else{
                    if(i > 0)   heights[i][j] = Math.min(heights[i][j], heights[i-1][j] + 1);
                    if(j > 0)   heights[i][j] = Math.min(heights[i][j], heights[i][j-1] + 1);
                }
            }
        }
        for(int i = isWater.length - 1; i >= 0; i--){
            for(int j = isWater[0].length - 1; j >= 0; j--){
                if(i < isWater.length - 1)  heights[i][j] = Math.min(heights[i][j], heights[i+1][j] + 1);
                if(j < isWater[0].length - 1)   heights[i][j] = Math.min(heights[i][j], heights[i][j+1] + 1);
            }
        }
        return heights;
    }
}