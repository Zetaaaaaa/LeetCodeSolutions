class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int c = 0, maxx = 0;
        for(int i = 0; i < n; i++){
            maxx = Math.max(maxx, arr[i]);
            if(maxx == i){
                c++;
            }
        }
        return c;
    }
}