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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if (second == null){
            second = root;
        }
        swap(first, second);
    }
    
    private void traverse(TreeNode root){
        if (root == null) return;
        traverse(root.left);
        if (prev != null && prev.val > root.val){
            if (first == null){
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
        }
        prev = root;
        traverse(root.right);
    }
    
    private void swap(TreeNode n1, TreeNode n2){
        int val = n1.val;
        n1.val = n2.val;
        n2.val = val;
    }
}