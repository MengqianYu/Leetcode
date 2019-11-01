/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = root;
        while (head.left != null){
            head = head.left;
        }
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    
    private void helper(Node root){
        if (root == null) return;
        helper(root.left);
        root.left = prev;
        if (prev != null){
            prev.right = root;
        }
        prev = root;
        helper(root.right);
    }
}