class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int dp[][]= new int[arr.length][arr.length];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        } 
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
         int ans=0;
       for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                int nextfib= arr[j]-arr[i];
                if(nextfib<arr[i] && map.containsKey(nextfib)){
                    int k= map.get(nextfib);
                    dp[i][j]= dp[k][i]+1;
                }else{
                    dp[i][j]=2;
                }
                ans= Math.max(ans,dp[i][j]);
            }
        }
       
        return ans>2?ans:0;
    }

    
}