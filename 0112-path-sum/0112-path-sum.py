# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        def has_sum(root, cs):
            if not root:
                return False
            cs += root.val

            if not(root.left or root.right):
                return cs == targetSum
            
            return has_sum(root.left, cs) or has_sum(root.right,cs)
        
        return has_sum(root, 0)
        