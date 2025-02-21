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
import java.util.*;

class FindElements {
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        set.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = node.val;

            if (node.left != null) {
                node.left.val = 2 * val + 1;
                queue.offer(node.left);
                set.add(node.left.val);
            }

            if (node.right != null) {
                node.right.val = 2 * val + 2;
                queue.offer(node.right);
                set.add(node.right.val);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */