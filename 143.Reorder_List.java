/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        int len = 0;
        ListNode curr = head;
        while (curr != null){
            len++;
            curr = curr.next;
        }
        int mid = (len-1)/2;
        ListNode midNode = head;
        for (int i = 0; i < mid; i++){
            midNode = midNode.next;
        }
        ListNode curr2 = reverse(midNode.next);
        midNode.next = null;
        curr = head;
        while (curr2 != null){
            ListNode next1 = curr.next;
            ListNode next2 = curr2.next;
            curr.next = curr2;
            curr2.next = next1;
            curr = next1;
            curr2 = next2;
        }   
    }
    
    private ListNode reverse(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode res = reverse(next);
        next.next = head;
        return res;
    }
}