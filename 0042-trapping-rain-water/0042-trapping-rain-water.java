class Solution {
    public int trap(int[] height) {
        int[] lm = new int[height.length];
        int[] rm = new int[height.length];
        for(int i = 0; i < height.length; i++){
            if(i==0){
                lm[i] = height[i];
                continue;
            }
            lm[i] = Math.max(height[i], lm[i-1]);
        }
        for(int i=height.length-1;i>=0;i--){
            if(i==height.length-1){
                rm[i] = height[i];
                continue;
            }
            rm[i] = Math.max(height[i],rm[i+1]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            ans += (Math.min(rm[i],lm[i]) - height[i]);
        }
        return ans;
    }
}