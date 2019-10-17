/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node dummy = new Node();
        dummy.next = head;
        Node next = flatten(head.next);
        Node child = flatten(head.child);
        if (child != null){
            head.next = child;
            child.prev = head;
            head.child = null;
            while (child.next != null){
                child = child.next;
            }
            child.next = next;
            if (next != null){
                next.prev = child;
            }
        }
        return head;
    }
}