/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);
        return merge(n1, n2);
    }
    
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (h1 != null && h2!= null){
            if (h1.val < h2.val){
                pointer.next = h1;
                h1 = h1.next;
            }
            else{
                pointer.next = h2;
                h2 = h2.next;
            }
            pointer = pointer.next;
        }
        if (h1 == null){
            pointer.next = h2;
        }
        else if (h2 == null){
            pointer.next = h1;
        }
        return dummy.next;
    }
}