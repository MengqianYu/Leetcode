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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = inorder.length-1;
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end){
        if (start > end || start < 0 || end >= inorder.length){
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int index = start;
        for (int i = start; i <= end; i++){
            if (inorder[i] == root.val){
                index = i;
                break;
            }
        }
        root.right = buildTree(inorder, postorder, index+1, end);
        root.left = buildTree(inorder, postorder, start, index-1);
        return root;
    }
}