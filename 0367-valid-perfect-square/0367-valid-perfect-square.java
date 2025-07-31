class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long s = 1, e = num;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            long t = mid * mid;
            if (t == num) {
                return true;
            }
            if (t > num) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }
}