/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int num = 0;
            if (!stack1.isEmpty()){
                num += stack1.pop();
            }
            if (!stack2.isEmpty()){
                num += stack2.pop();
            }
            int k = stack.pop();
            stack.push((num+k)%10);
            stack.push((num+k)/10);
        }
        if (stack.peek() == 0) stack.pop();
        while (!stack.isEmpty()){
            head.next = new ListNode(stack.pop());
            head = head.next;
        }
        return dummy.next;
    }
}