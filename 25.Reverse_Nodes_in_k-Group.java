/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        boolean found = true;
        ListNode node = head;
        for (int i = 0; i < k; i++){
            if (node == null){
                found = false;
                break;
            }
            node = node.next;
        }
        if (!found) return head;
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}