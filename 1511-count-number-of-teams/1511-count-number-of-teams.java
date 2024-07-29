class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        int[] small = new int[n];
        int[] greater = new int[n];

        for(int i = 0; i < n; i++) {
            int c1 = 0;
            int c2 = 0;
            for(int j = i + 1; j < n; j++) {
                if(rating[j] < rating[i]) c1++;
                if(rating[j] > rating[i]) c2++;
            }
            small[i] = c1;
            greater[i] = c2;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(rating[i] < rating[j]) {
                    count += greater[j];
                }
                if(rating[i] > rating[j]) {
                    count += small[j];
                }
            }
        }

        return count;
    }
}
