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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length-1, 0);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int start, int end, int index){
        if (start > end || index >= preorder.length || index < 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = 0;
        for (int i = start; i <= end; i++){
            if (inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        root.left = build(preorder, inorder, start, pos-1, index+1);
        root.right = build(preorder, inorder, pos+1, end, index+pos-start+1);
        return root;
    }
}