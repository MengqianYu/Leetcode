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
    Map<Integer, PriorityQueue<TreeNode>> map;
    Map<TreeNode, Integer> ymap;
    int min;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        ymap = new HashMap<>();
        min = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root, 0, 0);
        int i = min;
        while (map.containsKey(i)){
            PriorityQueue<TreeNode> pq = map.get(i);
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()){
                list.add(pq.poll().val);
            }
            res.add(list);
            i++;
        }
        return res;
    }
    
    public void dfs(TreeNode node, int px, int py){
        if (node == null){
            return;
        }
        min = Math.min(min, px);
        if (!map.containsKey(px)){
            map.put(px, new PriorityQueue<TreeNode>(new Comparator<TreeNode>(){
                public int compare(TreeNode n1, TreeNode n2){
                    if (ymap.get(n2) != ymap.get(n1)) return ymap.get(n2) - ymap.get(n1);
                    else return n1.val - n2.val;
                }
            }));
        }
        ymap.put(node, py);
        map.get(px).offer(node);
        dfs(node.left, px-1, py-1);
        dfs(node.right, px+1, py-1);
    }
}