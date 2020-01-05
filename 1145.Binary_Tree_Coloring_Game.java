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
    Map<TreeNode, Integer> map;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        map = new HashMap<>();
        TreeNode node = traverse(root, x);
        int target = n/2;
        if (calculate(node) <= target) return true;
        if (calculate(node.left) > target || calculate(node.right) > target){
            return true;
        }
        return false;
    }
    
    private int calculate(TreeNode root){
        if (root == null) return 0;
        if (!map.containsKey(root)){
            int left = calculate(root.left);
            int right = calculate(root.right);
            map.put(root, left+right+1);
        }
        return map.get(root);
    }
    
    private TreeNode traverse(TreeNode root, int x){
        if (root == null) return null;
        if (root.val == x) return root;
        TreeNode left = traverse(root.left, x);
        TreeNode right = traverse(root.right, x);
        if (left != null) return left;
        return right;
    }
}