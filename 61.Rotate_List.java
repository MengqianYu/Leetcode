/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        int pivot = len - k%len;
        ListNode node = new ListNode(0);
        node.next = head;
        for (int i = 0; i < pivot; i++){
            node = node.next;
        }
        tail.next = head;
        ListNode res = node.next;
        node.next = null;
        return res;
    }
}