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
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        map = new HashMap<>();
        int min = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int col = cols.poll();
            if (curr == null){
                continue;
            }
            if (!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            min = Math.min(min, col);
            map.get(col).add(curr.val);
            queue.offer(curr.left);
            cols.offer(col-1);
            queue.offer(curr.right);
            cols.offer(col+1);
        }
        int i = min;
        while (map.containsKey(i)){
            res.add(map.get(i));
            i++;
        }
        return res;
    }
}