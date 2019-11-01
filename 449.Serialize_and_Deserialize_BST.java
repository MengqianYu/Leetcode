/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left!=null){
            sb.append(",").append(serialize(root.left));
        }
        if (root.right!=null){
            sb.append(",").append(serialize(root.right));
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] ss = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
        return construct(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode construct(Queue<String> queue, int low, int high){
        if (queue.isEmpty()) return null;
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if (val > high || val < low) return null;
        TreeNode res = new TreeNode(val);
        queue.poll();
        res.left = construct(queue, low, val);
        res.right = construct(queue, val, high);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));