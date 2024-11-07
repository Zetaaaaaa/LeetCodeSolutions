class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitArr=new int[24];
        int n=candidates.length;
        int maxSize=0;

        for(int i=0; i<n;  i++){
            int k=0;
            int val=candidates[i];
            while(val>0){                
                bitArr[k] += (val&1);                                
                maxSize=Math.max(maxSize, bitArr[k]);
                k++;
                val= val>>1;
            }
        }

        return maxSize;
    }
}