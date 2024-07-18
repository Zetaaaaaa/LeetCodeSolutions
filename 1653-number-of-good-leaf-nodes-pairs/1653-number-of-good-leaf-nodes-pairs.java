/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        if (root == null || distance <= 1) return 0;
        dfs(root, distance);
        return count;
    }
    private int[] dfs(TreeNode root, int D) {
        int[] dists = new int[D+1];
        if (root == null) {
            return dists;
        }
        if (root.left == null && root.right == null) {
            dists[1] = 1;
            return dists;
        }
        int[] left = dfs(root.left, D);
        int[] right = dfs(root.right, D);
        for (int i = 1; i < D; i++) {
            for (int j = 1; j < D; j++) {
                if (i + j > D) break;
                count += left[i] * right[j];
            }
        }
        for (int i = 1; i < D-1; i++) {
            dists[i+1] = left[i] + right[i];
        }
        return dists;
    }
}