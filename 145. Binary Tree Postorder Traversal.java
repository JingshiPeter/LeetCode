// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class Solution{
    
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
                TreeNode prev = null;
                TreeNode curr = root;
                while(curr != null || !stack.isEmpty()){
                    while(curr != null){
                        stack.push(curr);
                        curr = curr.left;
                    }
                    curr = stack.peek();
                    if(curr.right != null && prev != curr.right) curr = curr.right;
                    else{
                        prev = curr;
                        result.add(stack.pop().val);
                        curr = null;
                    }
                }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.addFirst(curr.val);
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        return res;
    }
}
