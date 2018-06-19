/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
    
        ListNode p = head;
        int len = 0;
        while (p!=null) {
            len++;
            p = p.next;
        }
        int m = len - n + 1;
        p = newHead;
        while (m > 1) {
            p = p.next;
            m--;
        }
        p.next = (p.next).next;
        return newHead.next;
    }
}
