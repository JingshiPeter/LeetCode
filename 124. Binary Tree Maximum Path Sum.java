/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(root.val + left, root.val + right);
    }
}
