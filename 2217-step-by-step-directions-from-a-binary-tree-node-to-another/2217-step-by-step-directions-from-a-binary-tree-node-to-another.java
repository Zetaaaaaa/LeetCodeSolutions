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
    public boolean DFS(TreeNode currNode, StringBuilder path, int destVal) {
        if(currNode == null) return false;
        if(currNode.val == destVal) return true;
        if(DFS(currNode.left, path, destVal)) path.append("L");
        else if(DFS(currNode.right, path, destVal)) path.append("R");
        return path.length() > 0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        DFS(root, start, startValue);
        DFS(root, dest, destValue);

        int i = start.length(), j = dest.length();
        int cnt = 0;
        while(i > 0 && j > 0 && start.charAt(i-1) == dest.charAt(j-1)) {
            cnt++; i--; j--;
        }
        
        String sPath = "U".repeat(start.length() - cnt);
        String ePath = dest.reverse().toString().substring(cnt, dest.length());
        
        return sPath + ePath;
    }
}