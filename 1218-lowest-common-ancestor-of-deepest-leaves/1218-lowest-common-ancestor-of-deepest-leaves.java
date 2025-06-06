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
    private TreeNode lca(TreeNode root,int n1,int n2){
        if(root == null)
            return root;
        if(root.val==n1 || root.val ==n2)
            return root;
        TreeNode left = lca(root.left,n1,n2);
        TreeNode right = lca(root.right,n1,n2);
        if(left!=null && right!=null)
            return root;
        return left==null?right:left;
    }
    private TreeNode[] findfarthestdeepestnode(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode l=null,r=null;
        while(!q.isEmpty()){
            int s = q.size();
            l=null;r=null;
            for(int i=0;i<s;i++){
                TreeNode temp = q.poll();
                if(i==0)
                    l=temp;
                else if(i==s-1)
                    r = temp;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return new TreeNode[]{l,r};
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        TreeNode[] nodes = findfarthestdeepestnode(root);
        TreeNode l = nodes[0];
        TreeNode r = nodes[1];
        return (l!=null && r!=null)?lca(root,l.val,r.val):l==null?r:l;
     

    }
}