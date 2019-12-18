/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        Node node = x.right;
        while (node != null && node.left != null){
            node = node.left;
        }
        if (node != null) return node;
        node = x;
        Node parent = x.parent;
        while (parent != null){
            if (parent.left == node){
                return parent;
            }
            node = parent;
            parent = node.parent;
        }
        return null;
    }
}