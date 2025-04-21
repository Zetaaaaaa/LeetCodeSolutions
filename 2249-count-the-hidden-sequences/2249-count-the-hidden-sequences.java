class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count = 0;
        int prefiSum = 0;
        int maxPrefix = Integer.MIN_VALUE;
        int minPrefix = Integer.MAX_VALUE;
        for(int i=0;i<differences.length;i++){
            prefiSum+=differences[i];
            maxPrefix = Math.max(maxPrefix,prefiSum);
            minPrefix = Math.min(minPrefix,prefiSum);
        }           
        for(int i=lower;i<=upper;i++){
            if(maxPrefix+i<=upper && minPrefix+i>=lower)
                count++;
			else if(count>0)
                break;
        }
        return count;
    }
}