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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
       // System.out.println(start + " " + end);
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        if (start == end){
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            for (int j = 0; j < left.size(); j++){
                for (int k = 0; k < right.size(); k++){
                    TreeNode root =  new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}