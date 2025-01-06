class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] rightans = new int[n];
        int[] leftans = new int[n];
        int balls = boxes.charAt(n-1) -'0';
        rightans[n-1] = 0;
        

        for (int i = n-2; i >= 0; i--) {
            rightans[i] = rightans[i+1] + balls;
            balls += boxes.charAt(i) - '0';
        }

        balls = boxes.charAt(0) -'0';
        leftans[0] = 0;

        for (int i = 1; i < n; i++) {
            leftans[i] = leftans[i-1] + balls;
            balls += boxes.charAt(i) - '0';
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = leftans[i] + rightans[i];
        }


        
        return res;
    }
}