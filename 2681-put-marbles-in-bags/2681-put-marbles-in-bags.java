class Solution {
    public long putMarbles(int[] weights, int k) {
        int n  = weights.length;
       int [] pairs = new int [n-1];
       for(int i = 0 ;i<n-1;i++){
           pairs[i]=weights[i]+weights[i+1];
       }
         Arrays.sort(pairs);
       long max = 0;
       long min = 0;
       for(int i = 0 ;i<k-1;i++){
            min +=pairs[i];
              max+=pairs[n-2-i];
       }
       return max-min;
    }
}