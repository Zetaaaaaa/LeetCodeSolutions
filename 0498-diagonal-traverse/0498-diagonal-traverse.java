class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> v = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < m; i++) {
            int j = i, k = 0;
            List<Integer> temp = new ArrayList<>();
            while (j >= 0 && k < n) {
                temp.add(mat[j][k]);
                j--;
                k++;
            }
            if (flag % 2 == 0) {
                v.add(temp);
            } else {
                Collections.reverse(temp);
                v.add(temp);
            }
            flag++;
        }
        flag = (m % 2 == 0) ? 0 : 1;
        for (int i = 0; i < n - 1; i++) {
            int j = m - 1, k = i + 1;
            List<Integer> temp = new ArrayList<>();
            while (j >= 0 && k < n) {
                temp.add(mat[j][k]);
                j--;
                k++;
            }
            if (flag % 2 == 0) {
                v.add(temp);
            } else {
                Collections.reverse(temp);
                v.add(temp);
            }
            flag++;
        }
        List<Integer> ansList = new ArrayList<>();
        for (List<Integer> diag : v) {
            ansList.addAll(diag);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}