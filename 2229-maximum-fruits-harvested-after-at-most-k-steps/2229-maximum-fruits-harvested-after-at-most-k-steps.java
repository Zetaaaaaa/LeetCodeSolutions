class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int leftest = fruits[0][0];
        
        int base = 0;
        int l = 0, r = 0, n = fruits.length;
        
        for (int[] f : fruits) 
            if (f[0] == startPos) base += f[1];
            else if (f[0] > startPos) r++;
            else l++;
        
        for (int i = l - 2; i >= 0; i--) {
            fruits[i][1] += fruits[i + 1][1];
        }
        
        for (int i = n - r + 1; i < n; i++) {
            fruits[i][1] += fruits[i - 1][1];
        }
        
        int i = 1;
        int j = r;
        int ans = base;
        
        while (j > 0 && fruits[n - 1 - (r - j)][0] - startPos > k) {
            j--;
        }
        
        if (j > 0) ans += fruits[n - 1 - (r - j)][1];
        
        while (i <= l && startPos - fruits[l - i][0] <= k) {
            int toLeft = startPos - fruits[l - i][0];
            
            int toRight = j == 0 ? 0 : fruits[n - 1 - (r - j)][0] - startPos;
            
            if (toLeft + toRight + Math.min(toLeft, toRight) <= k) {
                int rightTmp = j == 0 ? 0 : fruits[n - 1 - (r - j)][1];
                ans = Math.max(ans, base + fruits[l - i][1] + rightTmp);
                i++;
            } else if (j > 0) {
                j--;
            } else {
                break;
            }
        }
        
        return ans;
    }
}