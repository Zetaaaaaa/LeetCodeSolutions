class Solution {
    public int maxEnvelopes(int[][] e) {
        if(e==null||e.length==0||e[0].length==0) return 0;
        Arrays.sort(e,(a,b)->a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        int[] dp=new int[e.length+1];
        int len=0,idx=0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<e.length;i++){
            idx=Arrays.binarySearch(dp,e[i][1]);
            idx=idx<0?-1-idx:idx;
            dp[idx]=e[i][1];
            len=Math.max(len,idx);
        }
        
        return len+1;
    }
}