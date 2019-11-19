/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null){
            TreeNode h = new TreeNode(head.val);
            return h;
        }
        ListNode prev = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;
        prev.next = slow;
        while (fast != null && fast.next != null){
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        TreeNode h = new TreeNode(slow.val);
        h.left = left;
        h.right = right;
        return h;
    }
}