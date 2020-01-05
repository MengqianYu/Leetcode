/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()){
            if (curr == null){
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}