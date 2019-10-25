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
    int max = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res, int depth){
        if (root == null) return;
        if (max < depth){
            res.add(root.val);
            max = depth;
        }
        helper(root.right, res, depth+1);
        helper(root.left, res, depth+1);
    }
}