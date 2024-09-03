class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char i : s.toCharArray()) {
            int value = i - 'a' + 1;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
        }
         while (k-- > 1) {
            int sum2 = 0;
            while (sum > 0) {
                sum2 += sum % 10;
                sum /= 10;
            }
            sum = sum2;
        }
        return sum;
    }
}