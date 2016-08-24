/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tmp = new LinkedList<Integer>();
            for(int i = 0; i < len; i++){
                TreeNode current = queue.remove();
                tmp.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            result.add(0,tmp);
        }
        return result;
    }
}
