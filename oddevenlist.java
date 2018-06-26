/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headO = head, headE = head.next;
        ListNode p = headO, q = headE;
        while (q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            if (q.next != null) {
                q = q.next;
            }
        }
        p.next = headE;
        return headO;
    }
}
