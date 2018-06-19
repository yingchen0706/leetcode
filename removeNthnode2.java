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
        ListNode p=newHead, q = p;
        int m = n;
        while (m>0) {
            q = q.next;
            m--;
        }
        while (q.next!=null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}
