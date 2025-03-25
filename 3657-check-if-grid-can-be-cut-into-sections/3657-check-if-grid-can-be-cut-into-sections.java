class Solution {
    public boolean checkValidCuts(int n, int[][] rec) {
        int ans = 0;
        Arrays.sort(rec, Comparator.comparingDouble(o -> o[1]));
        int count = 0;
        int last = rec[0][3];
        for(int i = 1;i < rec.length;i++) {
            if(rec[i][1] < last) {
                last = Math.max(last, rec[i][3]);
            }
            else {
                last = rec[i][3];
                count++;
            }
        }
        count++;
        ans = count;
        Arrays.sort(rec, Comparator.comparingDouble(o -> o[0]));
        count = 0;
        last = rec[0][2];
        for(int i = 1;i < rec.length;i++) {
            if(rec[i][0] < last) {
                last = Math.max(last, rec[i][2]);
            }
            else {
                last = rec[i][2];
                count++;
            }
        }
        count++;
        ans = Math.max(ans, count);
        return ans >= 3;
    }
}