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
    TreeNode parent;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        parent = null;
        if (p.right == null){
            find(root, p);
            return parent;
        }
        TreeNode res = p.right;
        while (res.left != null){
            res = res.left;
        }
        return res;
    }
    
    private void find(TreeNode root, TreeNode p){
        if (root == null || p == null) return;
        if (root.val == p.val) return;
        if (root.val > p.val){
            parent = root;
            find(root.left, p);
        }
        else{
            find(root.right, p);
        }
    }
}