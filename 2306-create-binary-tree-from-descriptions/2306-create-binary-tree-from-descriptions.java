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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parent = desc[0], child = desc[1], isLeft = desc[2];
            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));
            
            if (isLeft == 1) {
                nodes.get(parent).left = nodes.get(child);
            } else {
                nodes.get(parent).right = nodes.get(child);
            }
            
            children.add(child);
        }
        
        TreeNode root = null;
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                root = nodes.get(desc[0]);
                break;
            }
        }
        
        return root;
    }
    
    
}