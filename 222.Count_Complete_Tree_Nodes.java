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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int right = rightDepth(root.right);
        int left = leftDepth(root.left);›
        if (right == left){
            return (1 << (left+1)) -1;
        }
        else {
            int lnum = countNodes(root.left);
            int rnum = countNodes(root.right);
            return lnum+rnum+1;
        }
    }
    
    public int rightDepth(TreeNode root){
        if (root == null) return 0;
        return rightDepth(root.right)+1;
    }
    
    public int leftDepth(TreeNode root){
        if (root == null) return 0;
        return leftDepth(root.left)+1;
    }
}