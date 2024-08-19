class Solution {
    public int minSteps(int n) {
        final int sqrtN = (int) Math.sqrt(n);

        int moves = 0;
        for (int prime = 2; n > 1 && prime <= sqrtN; ++prime) {
            while ((n % prime) == 0) {
                n /= prime;
                moves += prime;
            }
        }
        
        return (n > 1) ? n + moves : moves;
    }
}