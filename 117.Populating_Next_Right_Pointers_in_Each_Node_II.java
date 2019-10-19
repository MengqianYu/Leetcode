/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node start = null;
        while (curr != null){
            Node left = curr.left;
            Node right = curr.right;
            if (start == null && left != null){
                start = left;
            }
            else if (start == null && right != null){
                start = right;
            }
            if (left != null && right != null){
                left.next = right;
            }
            else if (left != null){
                left.next = findNext(curr);
            }
            if (right != null){
                right.next = findNext(curr);
            }
            if (curr.next != null){
                curr = curr.next;
            }
            else{
                curr = start;
                start = null;
            }
        }
        return root;
    }
    
    private Node findNext(Node node){
        while (node.next != null){
            node = node.next;
            if (node.left != null){
                return node.left;
            }
            else if (node.right != null){
                return node.right;
            }
        }
        return null;
    }
}