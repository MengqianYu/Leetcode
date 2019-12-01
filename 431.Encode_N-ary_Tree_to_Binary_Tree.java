/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if (root.children.size() != 0){
            res.left = encode(root.children.get(0));
            TreeNode curr = res.left;
            for (int i = 1; i < root.children.size(); i++){
                curr.right = encode(root.children.get(i));
                curr = curr.right;
            }
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node res = new Node(root.val, new ArrayList<Node>());
        TreeNode curr = root.left;
        while (curr != null){
            res.children.add(decode(curr));
            curr = curr.right;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));