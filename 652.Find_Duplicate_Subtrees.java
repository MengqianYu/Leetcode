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
    Map<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private String helper(TreeNode root, List<TreeNode> res){
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("/");
        String left = helper(root.left, res);
        String right = helper(root.right, res);
        sb.append(left);
        sb.append(right);
        String s = sb.toString();
        map.put(s, map.getOrDefault(s, 0)+1);
        if (map.get(s) == 2){
            res.add(root);
        }
        return s;
    }
}