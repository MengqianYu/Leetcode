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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDown(root);
        return max;
    }
    
    private int maxDown(TreeNode root){
        if (root == null) return 0;
        int left = maxDown(root.left);
        int right = maxDown(root.right);
        int res = 0;
        int sum = root.val;
        if (left < 0 && right < 0){
            res = root.val;
        }
        else{
            res = root.val + Math.max(left, right);
        }
        if (left > 0){
            sum += left;
        }
        if (right > 0){
            sum += right;
        }
        max = Math.max(max, sum);
        return res;
    }
}