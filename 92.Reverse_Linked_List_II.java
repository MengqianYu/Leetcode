/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;
        ListNode start = head;
        for (int i = 0; i < m-1; i++){
            before = start;
            start = start.next;
        }
        //System.out.println(start.val);
        ListNode curr = start.next;
        ListNode prev = start;
        for (int i = 0; i < n-m; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //System.out.println(curr.val);
        before.next = prev;
        start.next = curr;
        return dummy.next;
    }
}