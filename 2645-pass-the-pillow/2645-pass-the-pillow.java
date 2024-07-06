class Solution {
    public int passThePillow(int n, int time) {
        int count = time/(n-1);
        return count % 2 == 0 ? (time % (n-1) + 1) : (n - time % (n - 1));
    }
}