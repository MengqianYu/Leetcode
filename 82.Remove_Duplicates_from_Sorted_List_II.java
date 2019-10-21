/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null && node1.val == node2.val){
            node1 = node2;
            node2 = node2.next;
        }
        return deleteDuplicates(node2);
    }
}